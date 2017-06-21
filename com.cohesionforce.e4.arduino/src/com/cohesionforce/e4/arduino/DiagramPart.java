
package com.cohesionforce.e4.arduino;

import java.io.IOException;
import java.util.Collection;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.CustomDataConstants;
import org.eclipse.sirius.business.api.session.DefaultLocalSessionCreationOperation;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionCreationOperation;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.ui.business.internal.command.CreateAndStoreGMFDiagramCommand;
import org.eclipse.sirius.diagram.ui.business.internal.dialect.DiagramDialectArrangeOperation;
import org.eclipse.sirius.diagram.ui.tools.internal.editor.DDiagramEditorImpl;
import org.eclipse.sirius.diagram.ui.tools.internal.editor.tabbar.Tabbar;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.session.SessionEditorInput;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;

import fr.obeo.dsl.arduino.ArduinoFactory;
import fr.obeo.dsl.arduino.Hardware;
import fr.obeo.dsl.arduino.Project;
import fr.obeo.dsl.arduino.Sketch;


public class DiagramPart {
	
	public static final String ARDUINO_VP = "Arduino";
	public static final String HARDWARE_KIT_VP = "Hardware Kit";
	public static final String BASE_PATH = "/tmp/";
	private URI semanticModelURI;
	
	@Inject
	public DiagramPart() {
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		final Session session = createAird(URI.createFileURI(BASE_PATH+"representations.aird"),
				new NullProgressMonitor());

		final String semanticModelPath = BASE_PATH+"model.arduino";
		initSemanticModel(session, semanticModelPath, new NullProgressMonitor());

		final String[] viewpointsToActivate = { ARDUINO_VP };
		enableViewpoints(session, viewpointsToActivate);

		Collection<DRepresentation> representations = DialectManager.INSTANCE
				.getAllRepresentations(session);
		for (DRepresentation representation : representations) {
			if ("Hardware".equals(representation.getName())) {
				
				DDiagramEditorImpl diagram = new DDiagramEditorImpl();
				
				try {
					
		            if (representation instanceof DSemanticDiagram) {
		                final DSemanticDiagram diag = (DSemanticDiagram) representation;
		                final Collection<EObject> gmfDiags = session.getServices().getCustomData(CustomDataConstants.GMF_DIAGRAMS, diag);

		                if (gmfDiags.isEmpty()) {
		                    /*
		                     * we have our diagrams but not the gmf ones => old aird
		                     * version or corrupted file
		                     */
		                    TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
		                    domain.getCommandStack().execute(new CreateAndStoreGMFDiagramCommand(session, diag));

		                    gmfDiags.addAll(session.getServices().getCustomData(CustomDataConstants.GMF_DIAGRAMS, diag));
		                }

		                // If the current DDiagram is shared on a CDO repository and
		                // some
		                // needed Viewpoints are not activated (for example a
		                // contributed
		                // activated layer)
		                Set<Viewpoint> viewpointsActivated = null;
		                for (final EObject object : gmfDiags) {
		                    final Diagram gmfDiag = (Diagram) object;
		                    if (gmfDiag != null) {
		                    	
		                        DialectEditor dialectEditor = null;
		                        URI uri = EcoreUtil.getURI(gmfDiag);
		                        String editorName = DialectUIManager.INSTANCE.getEditorName(representation);
		                        final IEditorInput editorInput = new SessionEditorInput(uri, editorName, session);

		    					diagram.init(new EditorSiteStub(), editorInput);
		    					diagram.createPartControl(parent);
		                    	
		    					Tabbar tabbar = diagram.getTabbar();
		    					
		                        new DiagramDialectArrangeOperation().arrange(diagram, diag);
		                    }
		                }
		                if (viewpointsActivated != null && !viewpointsActivated.isEmpty()) {
//		                    informOfActivateNeededViewpoints(viewpointsActivated);
		                }
		            }

					
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return;
			}
		}

	}

	@PreDestroy
	public void preDestroy() {

	}

	@Focus
	public void onFocus() {

	}

	@Persist
	public void save() {

	}

	private Session createAird(URI representationsURI, IProgressMonitor monitor) {
		final Session session;
		Session tempSession = null;
		SessionCreationOperation sessionCreationOperation = new 
				DefaultLocalSessionCreationOperation(representationsURI,
				monitor);
		try {
			sessionCreationOperation.execute();
			tempSession = sessionCreationOperation.getCreatedSession();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		if (tempSession != null) {
			session = tempSession;
		} else {
			session = null;
		}
		return session;
	}

	private void initSemanticModel(final Session session,
			final String semanticModelPath, final IProgressMonitor monitor) {
		
		session.getTransactionalEditingDomain()
				.getCommandStack()
				.execute(
						new RecordingCommand(session
								.getTransactionalEditingDomain()) {
							@Override
							protected void doExecute() {

								semanticModelURI = URI
										.createFileURI(
												semanticModelPath);
								Resource res = new ResourceSetImpl()
										.createResource(semanticModelURI);
								// Add the initial model object to the contents.
								final Project rootObject = ArduinoFactory.eINSTANCE
										.createProject();

								if (rootObject != null) {
									res.getContents().add(rootObject);
									final Hardware hardware = ArduinoFactory.eINSTANCE
											.createHardware();
									hardware.setName("Hardware");
									rootObject.setHardware(hardware);
									final Sketch sketch = ArduinoFactory.eINSTANCE
											.createSketch();
									sketch.setName("Sketch");
									sketch.setHardware(hardware);
									rootObject.setSketch(sketch);
								}
								try {
									res.save(null);
								} catch (IOException e) {
									e.printStackTrace();
								}

								session.addSemanticResource(semanticModelURI,
										monitor);

								// Add ardublock kit
								final URI defaultKitModelURI = URI
										.createPlatformPluginURI(
												"/fr.obeo.dsl.arduino.design/resources/ArdublockKit.arduino",
												true);
								session.addSemanticResource(defaultKitModelURI,
										monitor);

								session.save(monitor);
							}
						});
	}

	public static void enableViewpoints(final Session session,
			final String... viewpointsToActivate) {
		if (session != null) {
			session.getTransactionalEditingDomain()
					.getCommandStack()
					.execute(
							new RecordingCommand(session
									.getTransactionalEditingDomain()) {
								@Override
								protected void doExecute() {
									ViewpointSelectionCallback callback = new ViewpointSelectionCallback();

									for (Viewpoint vp : ViewpointRegistry
											.getInstance().getViewpoints()) {
										for (String viewpoint : viewpointsToActivate) {
											if (viewpoint.equals(vp.getName()))
												callback.selectViewpoint(
														vp,
														session,
														new NullProgressMonitor());
										}
									}
								}
							});
		}
	}

}
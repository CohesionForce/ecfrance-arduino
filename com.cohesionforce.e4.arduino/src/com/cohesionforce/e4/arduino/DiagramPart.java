
package com.cohesionforce.e4.arduino;

import java.io.IOException;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.DefaultLocalSessionCreationOperation;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionCreationOperation;
import org.eclipse.sirius.diagram.ui.tools.internal.editor.DDiagramEditorImpl;
import org.eclipse.sirius.ui.business.api.session.SessionEditorInput;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PartInitException;

import fr.obeo.dsl.arduino.ArduinoFactory;
import fr.obeo.dsl.arduino.Hardware;
import fr.obeo.dsl.arduino.Project;
import fr.obeo.dsl.arduino.Sketch;


public class DiagramPart {
	
	public static final String ARDUINO_VP = "Arduino";
	public static final String HARDWARE_KIT_VP = "Hardware Kit";
	private URI semanticModelURI;
	@Inject
	public DiagramPart() {
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		final Session session = createAird(URI.createPlatformResourceURI("file:///tmp/representations.aird", true),
				new NullProgressMonitor());

		final String semanticModelPath = "file:///tmp/model.arduino";
		initSemanticModel(session, semanticModelPath, new NullProgressMonitor());

		final String[] viewpointsToActivate = { ARDUINO_VP };
		enableViewpoints(session, viewpointsToActivate);

		final IEditorInput editorInput = (IEditorInput) new SessionEditorInput(semanticModelURI, "Diagram", session);
		
		Collection<DRepresentation> representations = DialectManager.INSTANCE
				.getAllRepresentations(session);
		for (DRepresentation representation : representations) {
			if ("Hardware".equals(representation.getName())) {
				
				DDiagramEditorImpl diagram = new DDiagramEditorImpl();
				try {
					diagram.init(new EditorSiteStub(), editorInput);
					diagram.createPartControl(parent);
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
		SessionCreationOperation sessionCreationOperation = new DefaultLocalSessionCreationOperation(representationsURI,
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
										.createPlatformResourceURI(
												semanticModelPath, true);
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
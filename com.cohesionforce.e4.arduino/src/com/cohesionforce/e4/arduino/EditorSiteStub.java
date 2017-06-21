package com.cohesionforce.e4.arduino;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IKeyBindingService;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;

public class EditorSiteStub implements IEditorSite {

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPluginId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRegisteredName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerContextMenu(String menuId, MenuManager menuManager, ISelectionProvider selectionProvider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider) {
		// TODO Auto-generated method stub

	}

	@Override
	public IKeyBindingService getKeyBindingService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWorkbenchPart getPart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWorkbenchPage getPage() {
		return new WorkbenchPageStub();
	}

	@Override
	public ISelectionProvider getSelectionProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shell getShell() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWorkbenchWindow getWorkbenchWindow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSelectionProvider(ISelectionProvider provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getService(Class<T> api) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasService(Class<?> api) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IEditorActionBarContributor getActionBarContributor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IActionBars getActionBars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerContextMenu(MenuManager menuManager, ISelectionProvider selectionProvider,
			boolean includeEditorInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerContextMenu(String menuId, MenuManager menuManager, ISelectionProvider selectionProvider,
			boolean includeEditorInput) {
		// TODO Auto-generated method stub

	}

}

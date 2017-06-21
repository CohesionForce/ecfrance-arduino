package com.cohesionforce.e4.arduino;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.INavigationHistory;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IReusableEditor;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.MultiPartInitException;
import org.eclipse.ui.PartInitException;

public class WorkbenchPageStub implements IWorkbenchPage {

	@Override
	public void addPartListener(IPartListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPartListener(IPartListener2 listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public IWorkbenchPart getActivePart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWorkbenchPartReference getActivePartReference() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePartListener(IPartListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePartListener(IPartListener2 listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSelectionListener(ISelectionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSelectionListener(String partId, ISelectionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPostSelectionListener(ISelectionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPostSelectionListener(String partId, ISelectionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public ISelection getSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ISelection getSelection(String partId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSelectionListener(ISelectionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSelectionListener(String partId, ISelectionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePostSelectionListener(ISelectionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePostSelectionListener(String partId, ISelectionListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void activate(IWorkbenchPart part) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void bringToTop(IWorkbenchPart part) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean close() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeAllEditors(boolean save) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeEditors(IEditorReference[] editorRefs, boolean save) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeEditor(IEditorPart editor, boolean save) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IViewPart findView(String viewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IViewReference findViewReference(String viewId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IViewReference findViewReference(String viewId, String secondaryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditorPart getActiveEditor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditorPart findEditor(IEditorInput input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditorReference[] findEditors(IEditorInput input, String editorId, int matchFlags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditorPart[] getEditors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditorReference[] getEditorReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditorPart[] getDirtyEditors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAdaptable getInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPerspectiveDescriptor getPerspective() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IViewReference[] getViewReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IViewPart[] getViews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWorkbenchWindow getWorkbenchWindow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWorkingSet getWorkingSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hideActionSet(String actionSetID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hideView(IViewPart view) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hideView(IViewReference view) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPartVisible(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEditorAreaVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reuseEditor(IReusableEditor editor, IEditorInput input) {
		// TODO Auto-generated method stub

	}

	@Override
	public IEditorPart openEditor(IEditorInput input, String editorId) throws PartInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditorPart openEditor(IEditorInput input, String editorId, boolean activate) throws PartInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditorPart openEditor(IEditorInput input, String editorId, boolean activate, int matchFlags)
			throws PartInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetPerspective() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean saveAllEditors(boolean confirm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveEditor(IEditorPart editor, boolean confirm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void savePerspective() {
		// TODO Auto-generated method stub

	}

	@Override
	public void savePerspectiveAs(IPerspectiveDescriptor perspective) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEditorAreaVisible(boolean showEditorArea) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPerspective(IPerspectiveDescriptor perspective) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showActionSet(String actionSetID) {
		// TODO Auto-generated method stub

	}

	@Override
	public IViewPart showView(String viewId) throws PartInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IViewPart showView(String viewId, String secondaryId, int mode) throws PartInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEditorPinned(IEditorPart editor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getEditorReuseThreshold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setEditorReuseThreshold(int openEditors) {
		// TODO Auto-generated method stub

	}

	@Override
	public INavigationHistory getNavigationHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IViewPart[] getViewStack(IViewPart part) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getNewWizardShortcuts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getPerspectiveShortcuts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getShowViewShortcuts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPerspectiveDescriptor[] getOpenPerspectives() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPerspectiveDescriptor[] getSortedPerspectives() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void closePerspective(IPerspectiveDescriptor desc, boolean saveParts, boolean closePage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeAllPerspectives(boolean saveEditors, boolean closePage) {
		// TODO Auto-generated method stub

	}

	@Override
	public IExtensionTracker getExtensionTracker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWorkingSet[] getWorkingSets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWorkingSets(IWorkingSet[] sets) {
		// TODO Auto-generated method stub

	}

	@Override
	public IWorkingSet getAggregateWorkingSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPageZoomed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void zoomOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public void toggleZoom(IWorkbenchPartReference ref) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPartState(IWorkbenchPartReference ref) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPartState(IWorkbenchPartReference ref, int state) {
		// TODO Auto-generated method stub

	}

	@Override
	public IWorkbenchPartReference getReference(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showEditor(IEditorReference ref) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hideEditor(IEditorReference ref) {
		// TODO Auto-generated method stub

	}

	@Override
	public IEditorReference[] openEditors(IEditorInput[] inputs, String[] editorIDs, int matchFlags)
			throws MultiPartInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEditorReference[] openEditors(IEditorInput[] inputs, String[] editorIDs, IMemento[] mementos,
			int matchFlags, int activateIndex) throws MultiPartInitException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IMemento[] getEditorState(IEditorReference[] editorRefs, boolean includeInputState) {
		// TODO Auto-generated method stub
		return null;
	}

}

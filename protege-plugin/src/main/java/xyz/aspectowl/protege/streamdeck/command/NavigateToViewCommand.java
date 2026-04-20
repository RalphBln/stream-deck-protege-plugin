package xyz.aspectowl.protege.streamdeck.command;

import org.protege.editor.core.ui.workspace.WorkspaceTab;
import org.protege.editor.owl.OWLEditorKit;

public final class NavigateToViewCommand extends CommandExecutor<NavigateToViewCommand.NavigateToViewParameters, NavigateToViewCommand.NavigateToViewResult> {
  
  @Override
  public NavigateToViewResult execute(OWLEditorKit editorKit) {
    WorkspaceTab tab = editorKit.getOWLWorkspace().getWorkspaceTab(getParameters().getTabId());
    if (tab == null) {
      throw new IllegalArgumentException("Illegal tab id " + getParameters().getTabId());
    }
    tab.requestSelection();
    editorKit.getOWLWorkspace().getViewManager().bringViewToFront(getParameters().getViewId());
    
    return new NavigateToViewResult();
  }
  
  static class NavigateToViewParameters implements CommandParameters {
    
    private String tabId;
    private String viewId;
    
    public String getTabId() {
      return tabId;
    }
    
    @SuppressWarnings("unused")
    public void setTabId(String tabId) {
      this.tabId = tabId;
    }
    
    public String getViewId() {
      return viewId;
    }
    
    @SuppressWarnings("unused")
    public void setViewId(String viewId) {
      this.viewId = viewId;
    }
  }
  
  static class NavigateToViewResult implements CommandResult {
  
  }
}

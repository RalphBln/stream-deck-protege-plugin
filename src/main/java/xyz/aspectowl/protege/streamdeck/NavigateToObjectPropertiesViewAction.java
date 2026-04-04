package xyz.aspectowl.protege.streamdeck;

import java.awt.event.ActionEvent;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.protege.editor.core.ui.workspace.TabbedWorkspace;
import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.OWLEditorKitFactory;
import org.protege.editor.owl.ui.action.ProtegeOWLAction;

public class NavigateToObjectPropertiesViewAction extends ProtegeOWLAction {

	public void initialise() throws Exception {
	}

	public void dispose() throws Exception {
	}

	public void actionPerformed(ActionEvent arg0) {
		((TabbedWorkspace) getOWLWorkspace()).getWorkspaceTab("org.protege.editor.owl.OWLEntitesTab").requestSelection();
		getOWLEditorKit().getOWLWorkspace().getViewManager().bringViewToFront("org.protege.editor.owl.OWLObjectPropertyTree");
	}
	
}

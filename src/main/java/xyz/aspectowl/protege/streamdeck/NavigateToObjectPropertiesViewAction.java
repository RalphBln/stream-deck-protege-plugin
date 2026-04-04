package xyz.aspectowl.protege.streamdeck;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.protege.editor.owl.ui.action.ProtegeOWLAction;

public class NavigateToObjectPropertiesViewAction extends ProtegeOWLAction {

	public void initialise() throws Exception {
	}

	public void dispose() throws Exception {
	}

	public void actionPerformed(ActionEvent arg0) {
		StringBuilder message = new StringBuilder("Yet another example menu item.\n");
		message.append("The active ontology has ");
		message.append(getOWLModelManager().getActiveOntology().getObjectPropertiesInSignature().size());
		message.append(" object properties.");
		JOptionPane.showMessageDialog(getOWLWorkspace(), message.toString());
	}
}

package xyz.aspectowl.protege.streamdeck.command;

import org.protege.editor.owl.OWLEditorKit;
import org.protege.editor.owl.model.OWLWorkspace;
import org.protege.editor.owl.model.event.EventType;
import org.protege.editor.owl.model.event.OWLModelManagerChangeEvent;
import org.protege.editor.owl.model.event.OWLModelManagerListener;
import org.protege.editor.owl.ui.inference.PrecomputeAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class StartReasonerCommand extends CommandExecutor<StartReasonerCommand.StartReasonerCommandParameters, StartReasonerCommand.StartReasonerCommandResult> {
  
  private final PrecomputeAction startReasonerAction = new PrecomputeAction();

  public StartReasonerCommand() {
    super();
  }
  
  @Override
  public StartReasonerCommandResult execute(OWLEditorKit editorKit) throws Exception {
    startReasonerAction.setEditorKit(editorKit);
    startReasonerAction.initialise();
    
    editorKit.getOWLModelManager().addListener(new OWLModelManagerListener() {
      @Override
      public void handleChange(OWLModelManagerChangeEvent event) {
        if (event.isType(EventType.ONTOLOGY_CLASSIFIED)) {
          startReasonerAction.dispose();
          editorKit.getOWLModelManager().removeListener(this);
        }
      }
    });
    startReasonerAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, OWLWorkspace.REASONER_INITIALIZE));
    
    return new StartReasonerCommandResult();
  }
  
  static class StartReasonerCommandParameters implements CommandParameters {
  }
  
  static class StartReasonerCommandResult implements CommandResult {}
}

package xyz.aspectowl.protege.streamdeck.command;

import org.protege.editor.owl.OWLEditorKit;

public abstract class CommandExecutor<T extends CommandParameters, S extends CommandResult> {
  
  private T parameters;
  
  public abstract S execute(OWLEditorKit editorKit) throws Exception;
  
  @SuppressWarnings("unused")
  public void setParameters(T parameters) {
    this.parameters = parameters;
  }
  
  public T getParameters() {
    return parameters;
  }
  
  static class SuccessResult implements CommandResult {
    String success;
  }
}

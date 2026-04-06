package xyz.aspectowl.protege.streamdeck.command;

import org.protege.editor.owl.OWLEditorKit;

public abstract class CommandExecutor<T extends CommandParameters> {
  
  private T parameters;
  
  public abstract void execute(OWLEditorKit editorKit) throws Exception;
  
  @SuppressWarnings("unused")
  public void setParameters(T parameters) {
    this.parameters = parameters;
  }
  
  public T getParameters() {
    return parameters;
  }
}

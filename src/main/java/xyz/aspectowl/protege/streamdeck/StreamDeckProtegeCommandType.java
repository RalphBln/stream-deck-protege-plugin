package xyz.aspectowl.protege.streamdeck;

import xyz.aspectowl.protege.streamdeck.command.CommandExecutor;
import xyz.aspectowl.protege.streamdeck.command.NavigateToViewCommand;

public enum StreamDeckProtegeCommandType {
  navigateToView(NavigateToViewCommand.class);
  
  private final Class<? extends CommandExecutor> executorClass;
  
  StreamDeckProtegeCommandType(Class<? extends CommandExecutor> executorClass) {
    this.executorClass = executorClass;
  }
  
  public Class<? extends CommandExecutor> getExecutorClass() {
    return executorClass;
  }
}

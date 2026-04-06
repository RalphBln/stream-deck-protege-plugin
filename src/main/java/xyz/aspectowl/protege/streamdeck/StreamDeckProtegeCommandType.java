package xyz.aspectowl.protege.streamdeck;

import xyz.aspectowl.protege.streamdeck.command.CommandExecutor;
import xyz.aspectowl.protege.streamdeck.command.CommandParameters;
import xyz.aspectowl.protege.streamdeck.command.NavigateToViewCommand;

public enum StreamDeckProtegeCommandType {
  navigateToView(NavigateToViewCommand.class);
  
  private final Class<? extends CommandExecutor<? extends CommandParameters>> executorClass;
  
  StreamDeckProtegeCommandType(Class<? extends CommandExecutor<? extends CommandParameters>> executorClass) {
    this.executorClass = executorClass;
  }
  
  public Class<? extends CommandExecutor<? extends CommandParameters>> getExecutorClass() {
    return executorClass;
  }
}

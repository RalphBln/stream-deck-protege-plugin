package xyz.aspectowl.protege.streamdeck;

import xyz.aspectowl.protege.streamdeck.command.*;

public enum StreamDeckProtegeCommandType {
  
  navigateToView(NavigateToViewCommand.class),
  startReasoner(StartReasonerCommand.class);
  
  private final Class<? extends CommandExecutor<? extends CommandParameters, ?extends CommandResult>> executorClass;
  
  StreamDeckProtegeCommandType(Class<? extends CommandExecutor<? extends CommandParameters, ? extends CommandResult>> executorClass) {
    this.executorClass = executorClass;
  }
  
  public Class<? extends CommandExecutor<? extends CommandParameters, ? extends CommandResult>> getExecutorClass() {
    return executorClass;
  }
}

package xyz.aspectowl.protege.streamdeck.command;

import xyz.aspectowl.protege.streamdeck.StreamDeckProtegeCommandType;

public class CommandResultSuccess implements CommandResult {
  
  private final StreamDeckProtegeCommandType commandType;
  
  public CommandResultSuccess(StreamDeckProtegeCommandType commandType) {
    this.commandType = commandType;
  }
  
  public StreamDeckProtegeCommandType getCommandType() {
    return commandType;
  }
}

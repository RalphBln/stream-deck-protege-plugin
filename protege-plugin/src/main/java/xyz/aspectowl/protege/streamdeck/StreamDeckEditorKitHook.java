package xyz.aspectowl.protege.streamdeck;

import org.protege.editor.owl.model.OWLEditorKitHook;

import java.net.InetSocketAddress;

public class StreamDeckEditorKitHook extends OWLEditorKitHook {
  
  private StreamDeckWebSocketServer streamDeck;
  
  @Override
  public void initialise() {
    streamDeck = new StreamDeckWebSocketServer(new InetSocketAddress(8910), getEditorKit());
    streamDeck.start();
  }
  
  @Override
  public void dispose() throws Exception {
    streamDeck.stop(0, "Protégé Stream Deck plug-in deactivated.");
  }
  
}

package xyz.aspectowl.protege.streamdeck;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.protege.editor.owl.OWLEditorKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.aspectowl.protege.streamdeck.command.CommandExecutor;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class StreamDeckWebSocketServer extends WebSocketServer {
  
  private final static Logger log = LoggerFactory.getLogger(StreamDeckWebSocketServer.class);
  
  private final OWLEditorKit editorKit;
  
  private final Gson gson;
  
  public StreamDeckWebSocketServer(InetSocketAddress address, OWLEditorKit editorKit) {
    super(address);
    this.editorKit = editorKit;
    
    RuntimeTypeAdapterFactory<CommandExecutor> taf =
            RuntimeTypeAdapterFactory.of(CommandExecutor.class, "command");
    Arrays.stream(StreamDeckProtegeCommandType.values()).forEach(commandType -> taf.registerSubtype(commandType.getExecutorClass(), commandType.name()));
    gson = new GsonBuilder().registerTypeAdapterFactory(taf).create();
  }
  
  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {
    conn.send("This is Protege's Stream Deck web socket server");
    log.info("Stream deck web socket connection to {}, opened", conn.getRemoteSocketAddress());
  }
  
  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    log.info("Stream deck web socket connection closed {} with exit code {} additional info: {}", conn.getRemoteSocketAddress(), code, reason);
  }
  
  @Override
  public void onMessage(WebSocket conn, String message) {
    log.info("Received message from {}: {}", conn.getRemoteSocketAddress(), message);
    JsonObject response = new JsonObject();
    try {
      CommandExecutor commandExecutor = gson.fromJson(message, CommandExecutor.class);
      commandExecutor.execute(editorKit);
      response.addProperty("success", commandExecutor.getClass().getSimpleName());
    } catch (Exception e) {
      response.addProperty("error", e.getMessage());
    } finally {
      conn.send(gson.toJson(response));
    }
    
  }
  
  @Override
  public void onMessage(WebSocket conn, ByteBuffer message) {
    log.error("Received ByteBuffer from {}", conn.getRemoteSocketAddress());
  }
  
  @Override
  public void onError(WebSocket conn, Exception ex) {
    log.error("An error occurred on connection {}", conn.getRemoteSocketAddress(), ex);
  }
  
  @Override
  public void onStart() {
    log.info("Stream deck web socket server started.");
  }
}
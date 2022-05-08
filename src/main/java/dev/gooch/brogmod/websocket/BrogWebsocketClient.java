package dev.gooch.brogmod.websocket;

import dev.gooch.brogmod.BrogMod;
import dev.gooch.brogmod.Util;
import net.minecraft.client.util.Session;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;

public class BrogWebsocketClient extends WebSocketClient {

    public final String URL = "ws://brog.gooch.dev:3000";

    BrogWebsocketClient(URI serverUri, Draft draft) {
        super(serverUri, draft);
    }

    public BrogWebsocketClient(URI serverURI) {
        super(serverURI);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Message msg = new Message();
        msg.setType("CONNECT");
        msg.setUsername(Util.getUsername());
        BrogMod.LOGGER.info("Sucessfully connected to the Broglands Websocket server!");
        this.send(msg.get());
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        BrogMod.LOGGER.error("Websocket closed with exit code " + code + " additional info: " + reason);
    }

    @Override
    public void onMessage(String message) {


        BrogMod.LOGGER.info("received message: " + message);
    }

    @Override
    public void onMessage(ByteBuffer message) {

        BrogMod.LOGGER.info("received ByteBuffer");
    }

    @Override
    public void onError(Exception ex) {
        System.err.println("an error occurred:" + ex);
    }

    public void sendMessage(String message) {
        if (this.isOpen()) {
            this.send(message);
        }
    }
}

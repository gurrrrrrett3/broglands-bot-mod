package dev.gooch.brogmod;

import dev.gooch.brogmod.websocket.BrogWebsocketClient;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.client.gui.hud.InGameHud;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;

public class BrogMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("brogmod");
	public static URI uri;
	public static BrogWebsocketClient wsClent;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		try {

			uri = new URI("wss://brog.gooch.dev/ws");
			LOGGER.info("Connecting to the Broglands Websocket...");
			long startTime = System.currentTimeMillis();

			//Connect
			wsClent =  new BrogWebsocketClient(uri);
			wsClent.connect();

		} catch (URISyntaxException ex) {
			LOGGER.error("Failed to connect to the Broglands websocket server :(", ex);
		}
	}

}

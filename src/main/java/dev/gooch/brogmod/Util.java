package dev.gooch.brogmod;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Session;

public class Util {

    public static String getUsername() {
        return MinecraftClient.getInstance().getSession().getUsername();
    }
}
package dev.gooch.brogmod.websocket;

import dev.gooch.brogmod.Util;

public class Message {
    public String username;
    public String text;
    public String type;
    public long time = System.currentTimeMillis();

    public void setType(String type) {
        this.type = type;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsername() {
        this.username = Util.getUsername();
    }

    public void setText(String text) {
        this.text = text;
    }

    public String get() {
        return type + "\n" +time + "\n" + username + "\n" + text;
    }


}
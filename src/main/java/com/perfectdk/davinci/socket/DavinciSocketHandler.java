package com.perfectdk.davinci.socket;

import org.springframework.web.socket.handler.TextWebSocketHandler;

public class DavinciSocketHandler extends TextWebSocketHandler {

    private static final DavinciSocketHandler handler = new DavinciSocketHandler();


    public static DavinciSocketHandler getHandler() {
        return handler;
    }
}

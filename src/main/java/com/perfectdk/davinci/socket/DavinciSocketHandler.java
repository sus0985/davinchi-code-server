package com.perfectdk.davinci.socket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class DavinciSocketHandler extends TextWebSocketHandler {

    public final Map<String, WebSocketSession> sessions = new HashMap<>();

    private static final DavinciSocketHandler handler = new DavinciSocketHandler();

    public static DavinciSocketHandler getHandler() {
        return handler;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);

        log.info("Socket connected with id: [{}]", session.getId());
        sessions.put(session.getId(), session);
        sendMessage("Connection established with id: [" + session.getId() + "]", session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);

        session.sendMessage(message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);

        log.info("Socket closed with id: [{}]", session.getId());
        sessions.remove(session.getId());
    }


    private void sendMessage(String message, WebSocketSession session) throws IOException {
        session.sendMessage(new TextMessage(message));
    }
}

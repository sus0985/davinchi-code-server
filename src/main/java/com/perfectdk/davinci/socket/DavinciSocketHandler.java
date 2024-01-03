package com.perfectdk.davinci.socket;

import com.perfectdk.davinci.repository.DavinciGameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class DavinciSocketHandler extends TextWebSocketHandler {

    private final DavinciGameRepository gameRepository;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        log.info("Socket connected with id: [{}]", session.getId());
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
    }

    private void sendMessage(String message, WebSocketSession session) throws IOException {
        session.sendMessage(new TextMessage(message));
    }
}

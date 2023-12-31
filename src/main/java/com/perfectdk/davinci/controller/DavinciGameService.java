package com.perfectdk.davinci.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@Slf4j
@Service
@ServerEndpoint(value = "/game")
public class DavinciGameService {

    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        log.info("{} onMessage message: {}", session, message);
    }

    @OnOpen
    public void onOpen(Session session) {
        log.info("{} onOpen", session);
    }

    @OnClose
    public void onClose(Session session) {
        log.info("{} onClose", session);
    }
}

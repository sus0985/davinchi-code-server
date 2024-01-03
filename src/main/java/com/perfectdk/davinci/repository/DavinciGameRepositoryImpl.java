package com.perfectdk.davinci.repository;

import com.perfectdk.davinci.socket.DavinciSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DavinciGameRepositoryImpl implements DavinciGameRepository {

    private final Map<String, WebSocketSession> sessions = Collections.synchronizedMap(new HashMap<>());

}

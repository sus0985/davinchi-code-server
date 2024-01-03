package com.perfectdk.davinci.socket;

import com.perfectdk.davinci.repository.DavinciGameRepository;
import com.perfectdk.davinci.repository.DavinciGameRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

    private static final String SOCKET_ENDPOINT = "/davinci";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getDavinciSocketHandler(), SOCKET_ENDPOINT)
                .setAllowedOrigins("*");
    }

    @Bean
    public DavinciGameRepository getDavinciGameRepository() {
        return new DavinciGameRepositoryImpl();
    }

    @Bean
    public DavinciSocketHandler getDavinciSocketHandler() {
        return new DavinciSocketHandler(getDavinciGameRepository());
    }

}

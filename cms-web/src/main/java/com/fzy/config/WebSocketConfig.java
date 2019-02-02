package com.fzy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @program: WebSocketConfig
 * @description:
 * @author: fzy
 * @date: 2019-02-01 21:02
 **/
@Configuration
public class WebSocketConfig{

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}

package com.kikop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author kikop
 * @version 1.0
 * @project Name: mywebsocketapp
 * @file Name: WebSocketConfig
 * @desc
 * @date 2021/3/30
 * @time 8:00
 * @by IDE: IntelliJ IDEA
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStomConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 设置socket连接
     *
     * @param stompEndpointRegistry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {

        // 设置前后台通讯的端点:
        // http://localhost:8085/fbSocket
        stompEndpointRegistry.addEndpoint("/fbSocket")
                // 解决跨域问题
                .setAllowedOrigins("*")
                //解决跨域问题
//                .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    /**
     * 设置发布订阅的主题:购物信息:myorder,学习信息:myscore
     *
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/myorder", "/myscore");
    }
}

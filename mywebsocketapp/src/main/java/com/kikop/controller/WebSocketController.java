package com.kikop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author kikop
 * @version 1.0
 * @project Name: mywebsocketapp
 * @file Name: WebSocketController
 * @desc
 * @date 2021/3/30
 * @time 8:00
 * @by IDE: IntelliJ IDEA
 */
@Controller
public class WebSocketController {

    // spring-messaging
    // 发送消息的模板
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    /**
     * 服务端想客户端发送消息
     */
    @RequestMapping("/ssendToClient")
    @ResponseBody
    public String ssendToClient() {

        // 订阅主题，只有订阅了这个主题的连接才会接收消息
        String topic = "/myorder/userId/10010";
        // 消息内容:String
        String message = "你好呀";
        simpMessagingTemplate.convertAndSend(topic, message);
        return "调用成功！";
    }

    /**
     * 客户端向客户端发送消息
     */
    @MessageMapping("/csendToClient")
    @SendTo("/myorder/userId/10010")
    @ResponseBody
    public String csendToClient(String msg) {
        System.out.println(msg);
        return msg;
    }

    /**
     * 返回首页
     * @return
     */
    @RequestMapping("/webSocketIndex")
    public String webSocketIndex() {
        return "webSocketIndex";
    }

}

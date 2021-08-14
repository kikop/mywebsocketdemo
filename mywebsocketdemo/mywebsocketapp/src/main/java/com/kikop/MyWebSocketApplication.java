package com.kikop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// 7、Spring Cloud Alibaba微服务系列-消息队列RocketMQ
// https://www.jianshu.com/p/1c8b97af2087


// netty 和webSocket 做一个及时通讯（二）
// https://www.jianshu.com/p/2864564464e0

// SpringCloud集群整合Rabbitmq、延迟队列、Stream实战
// https://www.jianshu.com/p/7365bcbb3cf6

@SpringBootApplication

// 注解扫描多个包下示例,内嵌包中有@Component注解,需开启如下内容
//@ComponentScan({"com.kikop"})
public class MyWebSocketApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(MyWebSocketApplication.class, args);

    }

}

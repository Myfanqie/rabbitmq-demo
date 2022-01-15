package cn.itcast.mq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 17521
 */
@Configuration
public class ExchangeConfig {

    /**
     * 交换机
     * @return
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("itcast.fanout");
    }

    @Bean
    public Queue fanQueue1(){
        return new Queue("fan.queue1");
    }

    @Bean
    public Queue fanQueue2(){
        return new Queue("fan.queue2");
    }

    /**
     * 绑定交换机和队列
     * @return
     */
    @Bean
    public Binding bindExchangeQueue1(FanoutExchange fanoutExchange, Queue fanQueue1){
        return BindingBuilder.bind(fanQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding bindExchangeQueue2(FanoutExchange fanoutExchange, Queue fanQueue2){
        return BindingBuilder.bind(fanQueue2).to(fanoutExchange);
    }



}

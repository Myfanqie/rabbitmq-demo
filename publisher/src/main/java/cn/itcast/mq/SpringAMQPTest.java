package cn.itcast.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringAMQPTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage1() {
        String queueName = "simple.queue";
        String message = "Hello spring amqp";
        rabbitTemplate.convertAndSend(queueName,message);
    }
    @Test
    public void sendMessage2() throws InterruptedException {
            String queueName = "simple.queue";
        for (int i = 1; i <= 50; i++) {
            String message = "Hello spring amqp"+i;
            rabbitTemplate.convertAndSend(queueName,message);
            Thread.sleep(20);
        }
    }

    @Test
    public void sendFanOutExchange() {
        String exchangeName = "itcast.fanout";
        rabbitTemplate.convertAndSend(exchangeName,"","我发送了一套消息");
    }

    @Test
    public void sendDirectExchange() {
        String directExchangeName = "itcast.direct";
        String routerKey = "red";
        rabbitTemplate.convertAndSend(directExchangeName,routerKey,"这个就是DirectExchange发送的消息");
    }
}

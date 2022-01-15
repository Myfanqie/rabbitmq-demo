package cn.itcast.mq.listen;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * @author liliya
 */
@Component
public class SpringRabbitListen {

    @RabbitListener(queues = "simple.queue")
    public void SpringRabbitListen1(String msg) throws InterruptedException {
        System.out.println("监听到的消息1--->>>" + msg + "->>" + LocalTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void SpringRabbitListen2(String msg) throws InterruptedException {
        System.err.println("监听到的消息2.......--->>>" + msg + "->>" + LocalTime.now());
        Thread.sleep(200);
    }

    @RabbitListener(queues = "fan.queue1")
    public void SpringRabbitListen3(String msg) throws InterruptedException {
        System.err.println("监听到fan.queue1的消息.......--->>>" + msg + "->>" + LocalTime.now());
    }

    @RabbitListener(queues = "fan.queue2")
    public void SpringRabbitListen4(String msg) throws InterruptedException {
        System.err.println("监听到fan.queue2的消息.......--->>>" + msg + "->>" + LocalTime.now());
    }

    //下面这里两个是direct的exchange交换机方式
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "itcast.direct"),
            key = {"blue","yello"})
    )
    public void SpringRabbitListen5(String msg) {
        System.err.println("监听到direct.queue1的消息.......--->>>" + msg + "->>" + LocalTime.now());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "itcast.direct"),
            key = {"blue","red"})
    )
    public void SpringRabbitListen6(String msg) {
        System.err.println("监听到direct.queue2的消息.......--->>>" + msg + "->>" + LocalTime.now());
    }
}

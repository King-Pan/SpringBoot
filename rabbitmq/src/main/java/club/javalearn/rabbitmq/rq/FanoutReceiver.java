package club.javalearn.rabbitmq.rq;

import club.javalearn.rabbitmq.config.RabbitConfig;
import club.javalearn.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author king-pan
 * @date 2018/11/29
 * @Description Fanout模式--消息接收类
 */
@Component
public class FanoutReceiver {

    // queues是指要监听的队列的名字

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE1)
    public void receiveTopic1(User user) {
        System.out.println("【receiveFanout1监听到消息】" + user);
    }

    @RabbitListener(queues = RabbitConfig.FANOUT_QUEUE2)
    public void receiveTopic2(User user) {
        System.out.println("【receiveFanout2监听到消息】" + user);
    }
}

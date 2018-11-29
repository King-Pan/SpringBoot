package club.javalearn.rabbitmq.rq;

import club.javalearn.rabbitmq.config.RabbitConfig;
import club.javalearn.rabbitmq.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author king-pan
 * @date 2018/11/29
 * @Description Topic模式--消息接受者（消费者）
 */
@Component
public class TopicReceiver {
    // queues是指要监听的队列的名字

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
    public void receiveTopic1(User user) {
        System.out.println("【receiveTopic1监听到消息】" + user);
    }

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE2)
    public void receiveTopic2(User user) {
        System.out.println("【receiveTopic2监听到消息】" + user);
    }
}

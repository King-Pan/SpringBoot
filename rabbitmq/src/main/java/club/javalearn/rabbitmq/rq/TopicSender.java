package club.javalearn.rabbitmq.rq;

import club.javalearn.rabbitmq.config.RabbitConfig;
import club.javalearn.rabbitmq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author king-pan
 * @date 2018/11/29
 * @Description Topic模式--消息发送
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(User user) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE,"lzc.message", user);
        this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "lzc.lzc", user);
    }
}

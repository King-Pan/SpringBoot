package club.javalearn.rabbitmq.rq;

import club.javalearn.rabbitmq.config.RabbitConfig;
import club.javalearn.rabbitmq.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author king-pan
 * @date 2018/11/29
 * @Description Topic模式--消息发送
 */
@Component
public class DirectSender  implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate  rabbitTemplate;


    public void send(User user) {
        this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.convertAndSend(RabbitConfig.DIRECT_EXCHANGE, "direct.pwl", user);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" 回调id:" + correlationData);
        if (ack) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + cause);
        }
    }
}

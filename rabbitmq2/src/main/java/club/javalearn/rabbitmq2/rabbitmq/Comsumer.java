package club.javalearn.rabbitmq2.rabbitmq;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author king-pan
 * @date 2018/11/29
 * @Description 消费者
 */
@Component
public class Comsumer {
    private Logger log = LoggerFactory.getLogger(Comsumer.class);

    @RabbitListener(queues = "fanout.queue1")
    public void process(Message message, Channel channel) throws IOException {
        // 采用手动应答模式, 手动确认应答更为安全稳定
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
        log.info("receive: " + new String(message.getBody()));
    }
}

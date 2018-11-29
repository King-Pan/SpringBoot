package club.javalearn.rabbitmq2.config;

import com.rabbitmq.client.AMQP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author king-pan
 * @date 2018/11/29
 * @Description ${DESCRIPTION}
 */
@Slf4j
@Configuration
public class RabbitMqConfig {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    public Queue queue() {
        return new Queue("fanout.queue1");
    }

    public RabbitTemplate rabbitTemplate() {
        //消息发送失败返回到队列中，yml需要配置publisher-returns: true
        rabbitTemplate.setMandatory(true);
        // 消息返回
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            String correlationId = message.getMessageProperties().getCorrelationId();
            if (log.isDebugEnabled()) {
                log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange, routingKey);
            }
        });

        //消息确认 yml需要配置 publisher-confirms: true
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                log.error("消息发送到exchange失败,原因: {}", cause);
            }else{
                log.info("-----------------------------消息确认成功");
            }
        });

        return rabbitTemplate;
    }
}

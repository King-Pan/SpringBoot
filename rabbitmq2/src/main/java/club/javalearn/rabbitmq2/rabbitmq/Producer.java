package club.javalearn.rabbitmq2.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author king-pan
 * @date 2018/11/29
 * @Description 生产者
 */
@Component
public class Producer {
        @Autowired
        private RabbitTemplate rabbitTemplate;

        /**
         * 给hello队列发送消息
         */
        @PostConstruct
        public void send() {
            for (int i =0; i< 100; i++) {
                String msg = "hello, 序号: " + i;
                System.out.println("Producer, " + msg);
                rabbitTemplate.convertAndSend("fanout.queue1", msg);
            }
        }
}

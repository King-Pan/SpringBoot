package club.javalearn.rabbitmq2;

import club.javalearn.rabbitmq2.rabbitmq.Producer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Rabbitmq2ApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() {
        producer.send();
    }

}

package club.javalearn.rabbitmq;

import club.javalearn.rabbitmq.entity.User;
import club.javalearn.rabbitmq.rq.DirectSender;
import club.javalearn.rabbitmq.rq.FanoutSender;
import club.javalearn.rabbitmq.rq.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private DirectSender directSender;

    /**
     * Fanout测试
     * @throws Exception
     */
    @Test
    public void testFanout() throws Exception {
        User user=new User();
        user.setId("1");
        user.setName("pwl");
        fanoutSender.send(user);
    }



    /**
     * TOPIC测试
     * @throws Exception
     */
    @Test
    public void testTopic() throws Exception {
        User user=new User();
        user.setId("1");
        user.setName("pwl");
        topicSender.send(user);
    }

    /**
     * DIRECT测试
     * @throws Exception
     */
    @Test
    public void testDirect() throws Exception {
        User user=new User();
        user.setId("1");
        user.setName("pwl");
        directSender.send(user);
    }

}

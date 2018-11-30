package club.javalearn.rabbitmq2;

import club.javalearn.rabbitmq2.rabbitmq.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Rabbitmq2Application {

    public static void main(String[] args) {
        SpringApplication.run(Rabbitmq2Application.class, args);
    }
}

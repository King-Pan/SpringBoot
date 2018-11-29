package club.javalearn.rabbitmq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author king-pan
 * @date 2018/11/29
 * @Description ${DESCRIPTION}
 */
@Data
public class User implements Serializable {
    private String id;
    private String name;
}

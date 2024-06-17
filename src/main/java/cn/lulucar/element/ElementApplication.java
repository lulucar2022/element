package cn.lulucar.element;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.lulucar.element.mapper")
@SpringBootApplication
public class ElementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElementApplication.class, args);
    }

}

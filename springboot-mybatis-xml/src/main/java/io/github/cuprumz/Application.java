package io.github.cuprumz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author cuprum
 * @date 2018/08/07
 */
@SpringBootApplication
@ComponentScan("io.github.cuprumz.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

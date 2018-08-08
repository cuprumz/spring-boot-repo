package io.github.cuprumz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author cuprumz
 * @date 2018/08/08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

    @Test
    public void contextLoads() {
        System.out.println("hello, Spring Boot Unit Test!");
    }
}

package io.github.cuprumz.di;

import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = FactoryBeanAppConfig.class)
public class Test {

    @Autowired
    private Tool tool;

//    @Resource(name = "tool")
    @Autowired
    private ToolFactory toolFactory;


    @org.junit.jupiter.api.Test
    public void testConstructWorkerByJava() {
        assertThat(tool.getId()).isEqualTo(1);
        assertThat(toolFactory.getFactoryId()).isEqualTo(8080);
    }

    @org.junit.jupiter.api.Test
    public void test() {
        System.out.println("ClassLoader of this class: " + Test.class.getClassLoader());
        System.out.println("ClassLoader of Logger: " + Logger.class.getClassLoader());
        System.out.println("ClassLoader of ArrayList: " + ArrayList.class.getClassLoader());
    }
}

package io.github.cuprumz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuprumz
 * @date 2018/08/11
 */
@RestController
public class HelloController {

    @RequestMapping({"/", "/index"})
    public String hello() {
        return "Hello, SpringBoot Actuator!";
    }

}

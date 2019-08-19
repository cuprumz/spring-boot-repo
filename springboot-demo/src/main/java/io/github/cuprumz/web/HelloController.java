package io.github.cuprumz.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuprumz
 * @date 2019/08/19
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index() {
        return "Hello, World!";
    }

}

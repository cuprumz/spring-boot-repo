package io.github.cuprumz.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuprumz
 * @date 2018/08/06
 */
@RestController
public class HelloController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "Hello, SpringBoot!";
    }
}

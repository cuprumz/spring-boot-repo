package io.github.cuprumz.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author cuprumz
 * @date 2018/08/07
 */
@Controller
public class HelloController {

    @RequestMapping({"/hello"})
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "Thymeleaf")String name) {
        model.addAttribute("name", name);
        return "hello";
    }
}

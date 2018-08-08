package io.github.cuprumz.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cuprum
 * @date 2018/08/08
 */
@Controller
public class MapController {

    @RequestMapping("/map/{path}")
    public String demo01(@PathVariable String path) {
        return "map/" + path;
    }
}

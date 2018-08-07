package io.github.cuprumz.web;

import io.github.cuprumz.pojo.User;
import io.github.cuprumz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author cuprumz
 * @date 2018/08/06
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/", "/index"})
    public String index() {

        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "/user/user_add";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Long id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/user_edit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/list";
    }

}

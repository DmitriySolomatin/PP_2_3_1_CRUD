package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String printUsers(ModelMap model, @RequestParam("count") Optional<Integer> count) {
        List<User> cars = userService.getUserList(count.orElse(100));
        model.addAttribute("cars", cars);
        return "index";
    }

}
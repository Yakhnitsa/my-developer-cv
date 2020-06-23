package com.yurets_y.mydevelopercv.controller;

import com.yurets_y.mydevelopercv.entities.User;
import com.yurets_y.mydevelopercv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class MainController {

    private UserService userService;

    @Value("${application.controller.sourcecode.github-link}")
    private String githubLink;

    @GetMapping
    public String mainPage(
        Model model
    ){
        User user = userService.getUser();
        model.addAttribute("user",user);
        model.addAttribute("githubLink",githubLink);
        return "index.html";
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

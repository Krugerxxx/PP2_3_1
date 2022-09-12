package org.example.web.controller;

import org.example.web.models.User;
import org.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class NewUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public String newUserForm(Model model) {
        model.addAttribute("newuser", new User());
        return "users/new_user";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.POST)
    public String newUserSubmit(@ModelAttribute @Validated User user, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/users";
        }
        userService.save(user);
        return "redirect:/users";
    }
}

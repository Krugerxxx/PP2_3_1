package org.example.web.controller;

import org.example.web.models.User;
import org.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class EditUserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/edit_user{id}", method = RequestMethod.GET)
    public String editUserForm(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("edituser", userService.getUser(id));
        return "users/edit_user";
    }

    @RequestMapping(value = "/edit_user{id}", method = RequestMethod.POST)
    public String editUser(@ModelAttribute @Validated User user, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/users";
        }
        userService.update(user);
        return "redirect:/users";
    }

}

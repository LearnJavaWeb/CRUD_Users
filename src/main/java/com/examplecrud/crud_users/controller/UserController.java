package com.examplecrud.crud_users.controller;

import com.examplecrud.crud_users.model.User;
import com.examplecrud.crud_users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/allUser")
    public String allUser(Model model){
        model.addAttribute("users",userService.getAllUser());
        return "user/listUser";
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user",new User());
        return "user/addUser";
    }
    @PostMapping("/add")
    public String addedUser(User users, Model model){
        userService.saveUser(users);
        model.addAttribute("message","New User Created Success!");
        return "user/addUser";
    }
    @GetMapping("/viewUser/{id}/view")
    public String viewUser(@PathVariable Long id, Model model){
        User user = userService.findUserById(id);
        if (id==user.getId()){
            model.addAttribute("user",user);
            return "user/viewUser";
        }else {
            return "error";
        }
    }
    @GetMapping("/editUser/{id}/")
    public String editUser(@PathVariable Long id,Model model){
        User user = userService.findUserById(id);
        if (user!=null){
            model.addAttribute("user",user);
            return "user/editUser";
        }else {
            return "/error";
        }

    }
    @PostMapping("/editUser/")
    public String editedUser(@ModelAttribute("user") User user, Model model){
        userService.saveUser(user);
        model.addAttribute("message","Save user successful! ");
        return "user/editUser";
    }
    @GetMapping("/deleteUser/{id}/")
    public String deleteUser(@PathVariable Long id, Model model){
        User user = userService.findUserById(id);
        if (user !=null){
            model.addAttribute("user",user);
            return "user/deleteUser";
        }else {
            return "/error";
        }
    }
    @PostMapping("/deleteUser/")
    public String deletedUser(@ModelAttribute("user") User user, Model model){
        userService.removeUser(user.getId());
        model.addAttribute("message","success");
        return "user/deleteUser";
    }
}
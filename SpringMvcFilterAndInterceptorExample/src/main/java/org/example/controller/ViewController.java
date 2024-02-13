package org.example.controller;

import org.example.dto.User;
import org.example.dto.UserFormData;
import org.example.message.MessageGenerator;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@Controller
@RequestMapping(path = "/view")
public class ViewController {
    private final UserService userService;
    MessageGenerator message;

    @Autowired
    public ViewController(UserService userService,MessageGenerator message) {
        this.userService = userService;
        this.message=message;
    }

    @GetMapping("/profile/{userId}")
    public String getProfileView(@PathVariable("userId") long userId, Model model) {
        User user = userService.getUser(userId);
        model.addAttribute("id", user.id());
        model.addAttribute("firstName", user.firstName());
        model.addAttribute("lastName", user.lastName());
        model.addAttribute(
                "age",
                user.birthDate() == null ? "" : Period.between(user.birthDate(), LocalDate.now()).getYears()
        );
        model.addAttribute("email", user.email() != null ? user.email() : "");
        model.addAttribute("message", message.welcome());
        return "user_profile";
    }

    @GetMapping("/profile/{userId}/status")
    public String getStatus(@PathVariable("userId") long userId, Model model){
        User user = userService.getUser(userId);
        UserFormData userFormData = new UserFormData();
        userFormData.setFirstName(user.firstName());
        userFormData.setLastName(user.lastName());
        userFormData.setBirthDate(user.birthDate());
        userFormData.setEmail(user.email());
        userFormData.setStatus(user.status());
        model.addAttribute("userForm", userFormData);
        model.addAttribute("userId", userId);
        model.addAttribute("message", message.welcome());
        return "user_status";
    }

    @PatchMapping("/profile/{userId}/status")
    public String setStatus(@ModelAttribute("userForm") UserFormData userForm, @PathVariable("userId") long userId, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "user_registration_error";
        }
        User user=new User(userService.getUser(userId),userForm.getStatus());
        userForm.setFirstName(user.firstName());
        userForm.setLastName(user.lastName());
        userForm.setBirthDate(user.birthDate());
        userForm.setEmail(user.email());
        System.out.println(userId);
        System.out.println(userForm);
        model.addAttribute("userForm", userForm);
        model.addAttribute("id", userId);
        model.addAttribute("message", message.welcome());
        return "user_profile";
    }

    @GetMapping("register")
    public String getRegisterForm(Model model) {
        model.addAttribute("userForm", new UserFormData());
        model.addAttribute("message", message.welcome());
        return "user_registration";
    }

    @PostMapping("register")
    public String register(@ModelAttribute("userForm") UserFormData userForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user_registration_error";
        }
        User newUser = userService.createUser(userForm.toUser());
        model.addAttribute("userForm", userForm);
        model.addAttribute("newUser", newUser);
        model.addAttribute("message", message.welcome());
        return "user_registered";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }

    @GetMapping("/profile/{userId}/edit")
    public String getEditProfileForm(@PathVariable("userId") long userId, Model model) {
        User user = userService.getUser(userId);
        UserFormData userFormData = new UserFormData();
        userFormData.setFirstName(user.firstName());
        userFormData.setLastName(user.lastName());
        userFormData.setBirthDate(user.birthDate());
        userFormData.setEmail(user.email());
        model.addAttribute("editForm", userFormData);
        model.addAttribute("userId", userId);
        model.addAttribute("message", message.welcome());
        return "user_profile_edit";
    }

    @PutMapping("/profile/{userId}/edit")
    public String editProfile(
            @PathVariable("userId") long userId,
            @ModelAttribute("editForm") UserFormData userForm,
            BindingResult result, Model model
    ) {
        if (result.hasErrors()) {
            return "user_profile_edit_error";
        }
        User updatedUserDto = userService.updateUser(userId, userForm.toUser());
        model.addAttribute("updatedUser", updatedUserDto);
        model.addAttribute("message", message.welcome());
        return "user_profile_edit_success";
    }
}

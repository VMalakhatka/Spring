package org.example.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.validation.Valid;
import org.example.dto.FriendFormData;
import org.example.pojo.Friend;
import org.example.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class WriteFriend {
    private RegistrationService registrationService;

    @Autowired
    public WriteFriend(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/friend")
    public String getRegistrationForm(Model model) {
        model.addAttribute("friend", new FriendFormData());
        return "write_friend";
    }

    @PostMapping("/friend")
    public String createFriend(
            @ModelAttribute("friend") @Valid FriendFormData friendFormData,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors())
            //return "write_friend";
            return "redirect: /error_data";
        Friend friend = new Friend(friendFormData.getFirstName(), friendFormData.getLastName(),
                friendFormData.getBirthday());
        registrationService.addParticipant(friend);
        model.addAttribute("surname", friend.lastName());
        return "redirect:/friends";
    }

    @GetMapping("/friends")
    public String getParticipants(Model model) {
        model.addAttribute("friends",registrationService.getFriends());
        return "friends";
    }

    @GetMapping("/friend/by_birthday")
    public String showFriendByDate(@RequestParam("date") LocalDate date, Model model){
        Friend friend = registrationService.getFriend(date).orElse(null);
        if (friend == null) {
            return "redirect: /not_found";
        }
//                orElse(new Friend(" No friend "," with this date ",date));
        model.addAttribute("friend",friend);
        System.out.println(friend);
        return "showFriend";
    }

    @GetMapping("/error_data")
    @ResponseBody
    public ResponseEntity<String> error_data(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                header("data","error").body("Error in data");
    }

    @GetMapping("/not_found")
    @ResponseBody
    public ResponseEntity<String> notFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                header("friend","not found").body("Friend not found");
    }

}

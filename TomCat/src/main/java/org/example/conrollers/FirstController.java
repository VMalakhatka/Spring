package org.example.conrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/truth")
    public String showTruth(){
        return "show_truth";
    }

    @GetMapping("/lie")
    public String showLie(){
        return "show_lie";
    }
}

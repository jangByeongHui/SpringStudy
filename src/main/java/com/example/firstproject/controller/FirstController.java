package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/")
    public String niceToMeetYou(Model model){
        model.addAttribute("username","병희");
        model.addAttribute("age",25);
        return "greetings"; //templates/greeting.mustache -> 브라우저로 전송!
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","병희");
        return "goodbye";
    }
}

package com.jen.sau;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @GetMapping("/playagame")
    public String playGame(
        @RequestParam(name="choice",required=false)
            String theChoice,Model model){
        if(theChoice == null){
            return "index";
        }
        String theOutcome = "error";
        if(theChoice.equals("rock")) {
            theOutcome = "tie";
        }
        if(theChoice.equals("paper")){
            theOutcome = "win";
        }
        if(theChoice.equals("scissors")){
            theOutcome = "loss";
        }
        model.addAttribute("outcome",theOutcome);
        return "results";
    }
}

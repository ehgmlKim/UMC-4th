package com.example.umc4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class testController {
    @GetMapping("/test")
    public String test(){
        return "index";
    }
}

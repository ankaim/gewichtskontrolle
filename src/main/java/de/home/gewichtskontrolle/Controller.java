package de.home.gewichtskontrolle;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/")
    public String test(){
        return "index";
    }

    @RequestMapping("/editor")
    public String test1(){
        return "editor";
    }

    @RequestMapping("/bericht")
    public String test2(Model model){
        model.addAttribute("message", "Здравствуйте User");
        return "main";
    }

    @RequestMapping("/test")
    public String test3(){
        return "test";
    }

}

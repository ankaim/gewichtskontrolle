package de.home.gewichtskontrolle;

import de.home.gewichtskontrolle.entitys.Bericht;
import de.home.gewichtskontrolle.repositories.BerichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    BerichtRepository berichtRepository;


    @RequestMapping("/all")
    public Iterable<Bericht> allPrint(){
        return berichtRepository.findAll();
    }

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

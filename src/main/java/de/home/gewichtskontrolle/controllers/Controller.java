package de.home.gewichtskontrolle.controllers;

import de.home.gewichtskontrolle.Addelement;
import de.home.gewichtskontrolle.entitys.Bericht;
import de.home.gewichtskontrolle.repositories.BerichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Date;

/**
 * Implementation of{@link org.springframework.stereotype.Controller}
 *
 * @author Anatoly Ekert
 * @version 1.0
 */

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    BerichtRepository berichtRepository;

    Addelement addelement;

    @RequestMapping("/")
    public String test(Model model) throws IOException {
        model.addAttribute("message", "Hallo Anatoly");
        addelement.addJson();
        return "index";
    }

//    @RequestMapping(value = "/te", method = RequestMethod.GET)
//    public String ers(){
//        return "form";
//    }
//    @RequestMapping(value = "/te", method = RequestMethod.POST)
//    public String zwe(HttpServletRequest request, Model model){
//        model.addAttribute("name", request.getParameter("name"));
//        return "index";
//    }

    @RequestMapping(value = "/te", method = RequestMethod.GET)
    public String ers(Model model) {
        model.addAttribute("bericht", new Bericht());
        return "form";
    }
//    @RequestMapping(value = "/te", method = RequestMethod.POST)
//    public String zwe(@ModelAttribute Bericht bericht, Model model){
//        berichtRepository.save(bericht);
//        model.addAttribute("name", bericht);
//        return "index";
//    }

    @RequestMapping("/bericht")
    public String test2(Model model) throws IOException {

        Iterable<Bericht> all = berichtRepository.findAll();
        model.addAttribute("message", all);
        return "main";
    }

    @RequestMapping("/f")
    public String formMy(Model model) {
        model.addAttribute("objectBericht", new Bericht());
        return "editor";
    }

    @RequestMapping("/main")
    public String meinMy(@ModelAttribute Bericht bericht, Model model) {
        bericht.setDate(new Date());
        berichtRepository.save(bericht);
        model.addAttribute("name", berichtRepository.findAll());
        return "main";
    }

}

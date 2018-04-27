package de.home.gewichtskontrolle.controllers;

import de.home.gewichtskontrolle.repositories.BerichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/")
    public String indexAll(Model model){
        model.addAttribute("data", berichtRepository.findAll());
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        berichtRepository.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id){
        return "redirect:/";
    }

    @RequestMapping("/new")
    public String newString(){
        return "redirect:/";
    }

}

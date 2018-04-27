package de.home.gewichtskontrolle.controllers;

import de.home.gewichtskontrolle.entitys.Bericht;
import de.home.gewichtskontrolle.repositories.BerichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/form")
    public String newString(Model model){
        model.addAttribute("objectBericht", new Bericht());
        return "form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Bericht bericht){
        berichtRepository.save(bericht);
        return "redirect:/";
    }

    @RequestMapping("/editor/{id}")
    public String editor(@PathVariable("id") Integer id, Model model){
        System.out.println(berichtRepository.findById(id).get().getData());
        model.addAttribute("data", berichtRepository.findById(id).get().getData());
        model.addAttribute("weight", berichtRepository.findById(id).get().getWeight());
        return "editor";
    }

}

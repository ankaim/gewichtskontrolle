package de.home.gewichtskontrolle.controllers;

import de.home.gewichtskontrolle.entitys.Bericht;
import de.home.gewichtskontrolle.repositories.BerichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam(value = "r", required = false)Integer w,
                         @RequestParam(value = "rb", required = false)String ww,
                         @RequestParam(value = "rbn", required = false)Integer www){
        Bericht ber = new Bericht(w, ww, www);
        System.out.println(ber);
        berichtRepository.save(ber);
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
        model.addAttribute("id", id);
        model.addAttribute("data", berichtRepository.findById(id).get().getData());
        model.addAttribute("weight", berichtRepository.findById(id).get().getWeight());
        model.addAttribute("objectBericht", new Bericht());
        return "editor";
    }

}

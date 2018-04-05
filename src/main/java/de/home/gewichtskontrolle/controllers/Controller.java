package de.home.gewichtskontrolle.controllers;

import de.home.gewichtskontrolle.entitys.Bericht;
import de.home.gewichtskontrolle.repositories.BerichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedWriter;
import java.io.FileWriter;
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


    @RequestMapping("/")
    public String test(Model model) throws IOException {
        model.addAttribute("message", "Hallo Anatoly");
        Iterable<Bericht> all = berichtRepository.findAll();

        int ein = 0;
        int zwei = 0;
        int drei = 0;
        int vier = 0;

        String d = "";
        String c = "";

        String df = "";
        for (Bericht l : all) {

            String g = l + "";

            ein = g.indexOf(" ") + 6;
            zwei = g.lastIndexOf(" ") - 1;
            drei = g.lastIndexOf(" ") + 8;
            vier = g.length() - 1;

            d = g.substring(ein, zwei);
            c = g.substring(drei, vier);

            df = df + "{\"c\": [{\"v\": \"" + d + "\", \"f\": null}, {\"v\":" + c + ", \"f\": null}]}," + "\n";
        }

        String temp = "{\n" +
                "  \"cols\": [\n" +
                "    {\"id\": \"\", \"label\": \"data\", \"type\": \"string\"},\n" +
                "    {\"id\": \"\", \"label\": \"weight\", \"type\": \"number\"}\n" +
                "  ],\n" +
                "  \"rows\": [" + df + "]\n" +
                "}";

        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/static/text.json"));
        bw.write(temp);
        bw.close();

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

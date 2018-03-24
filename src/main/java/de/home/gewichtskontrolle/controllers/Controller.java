package de.home.gewichtskontrolle.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.home.gewichtskontrolle.entitys.Bericht;
import de.home.gewichtskontrolle.repositories.BerichtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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


    @RequestMapping("/all")
    public void allPrint() throws IOException {
        Iterable<Bericht> all = berichtRepository.findAll();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String json = gson.toJson(all);

        BufferedWriter bw = new BufferedWriter(new FileWriter("text.json"));
        bw.write(json);
        bw.close();

    }

    @RequestMapping("/")
    public String test() {
        return "index";
    }

    @RequestMapping("/editor")
    public String test1() {
        return "editor";
    }

    @RequestMapping("/bericht")
    public String test2(Model model) {
        model.addAttribute("message", "Здравствуйте User");
        return "main";
    }

    @RequestMapping("/test")
    public String test3() {
        return "test";
    }

}

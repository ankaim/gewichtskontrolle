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

    @RequestMapping("/")
    public String test() throws IOException {
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

    @RequestMapping("/editor")
    public String test1() {
        return "editor";
    }

    @RequestMapping("/bericht")
    public String test2(Model model) throws IOException {

        Iterable<Bericht> all = berichtRepository.findAll();

        model.addAttribute("message", all);
        return "main";
    }


}

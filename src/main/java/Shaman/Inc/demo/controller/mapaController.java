package Shaman.Inc.demo.controller;

import Shaman.Inc.demo.WebScrapping;
import Shaman.Inc.demo.model.Region;
import Shaman.Inc.demo.model.data.RegionDao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;


@Controller
@RequestMapping(value = "")
public class mapaController {

    @Autowired
    private RegionDao regionDao;

    @RequestMapping(value = "")
    public String mostrar_mapa(Model modelo) throws IOException {
        WebScrapping web= new WebScrapping();
        String activos=web.webScappingActivos();
        modelo.addAttribute("regiones", regionDao.findAll());
        modelo.addAttribute("activos",activos);
        return "index2";
    }
    @RequestMapping(value = "sintomas")
    public String mostrar_sintomas(Model modelo) throws IOException {
        modelo.addAttribute("regiones", regionDao.findAll());
        return "sintomas";
    }



}

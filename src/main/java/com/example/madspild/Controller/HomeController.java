package com.example.madspild.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/fakta")
    public String fakta() {
        return "fakta";
    }

    @GetMapping("/madbanken")
    public String madbanken() {
        return "madbanken";
    }

    @GetMapping("/omos")
    public String omos() {
        return "omos";
    }


    @GetMapping("/tipstricks")
    public String tipstricks()
    {
        return "tipstricks";
    }
    @GetMapping("/saesonkalender")
    public String saesonkalender()
    {
        return "saesonkalender";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/opretbruger")
    public String opretBruger() {
        return "opretbruger";
    }

    @GetMapping("/minSide")
    public String minSide() {
        return "minSide";
    }
}
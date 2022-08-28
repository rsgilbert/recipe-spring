package net.passioncloud.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("")
    public String getIndex() {
        System.out.println("Say 1234 jj tom kke 2");
        return "index";
    }
}

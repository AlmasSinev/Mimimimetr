package com.ildarado.mimimimetr.controller;

import com.ildarado.mimimimetr.repos.CatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CatRepo catRepo;

    @GetMapping("/")
    public String greeting (Map<String, Object> model) {
        return "index";
    }
}

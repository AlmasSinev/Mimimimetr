package com.ildarado.mimimimetr.controller;

import com.ildarado.mimimimetr.domain.Cat;
import com.ildarado.mimimimetr.repos.CatRepo;
import com.ildarado.mimimimetr.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private CatService catService;

    @GetMapping("/")
    public String greeting (Map<String, Object> model) {
        return "index";
    }



    @GetMapping("/winners")
    public String showWinners(Map<String, Object> model){

        List<Cat> winnersCats = (List<Cat>) catService.getWinners();
        model.put("cats", winnersCats);
        return "winners";
    }
}

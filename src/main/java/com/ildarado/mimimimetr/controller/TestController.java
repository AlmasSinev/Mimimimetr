package com.ildarado.mimimimetr.controller;

import com.ildarado.mimimimetr.domain.Cat;
import com.ildarado.mimimimetr.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @Autowired
    private CatService catService;

    @GetMapping("/test")
    public String startTest(Cat cat, Model model) {
        cat = catService.getRandomCat();
        if (!cat.getName().equals("STOP CATS LIST")){
            model.addAttribute("cat", cat);
        } else {
            return "redirect:/winners";
        }
        Cat cat2 = catService.getRandomCat();
        if (!cat2.getName().equals("STOP CATS LIST")){
            model.addAttribute("cat2", cat2);
        } else {
            return "redirect:/winners";
        }
        return "test";
    }

    @PostMapping("/test/")
    public String testing(Cat cat) {

        cat.setVoicesCount(cat.getVoicesCount() + 1);
        catService.saveCat(cat);
        return "redirect:/test";
    }
}

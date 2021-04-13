package com.ildarado.mimimimetr.controller;

import com.ildarado.mimimimetr.domain.Cat;
import com.ildarado.mimimimetr.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class AddNewCatController {

    @Autowired
    CatService catService;


    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/addCat")
    public String createCat() {
        return "addCat";
    }

    @PostMapping("/addCat")
    public String addCat (@RequestParam String name,
                          Map<String, Object> model,
                          @RequestParam("file") MultipartFile file) throws IOException {

        Cat cat = new Cat(name);

        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists())
                uploadDir.mkdir();
            String uuidFile =  UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFilename));
            cat.setFilename(resultFilename);
        }


        if (!catService.addCat(cat)) {
            model.put("message", "Котик с таким именем уже существует!");
            return "addCat";
        } else {
            catService.addCat(cat);
        }
        return "redirect:/";
    }
}

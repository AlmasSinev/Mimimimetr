package com.ildarado.mimimimetr.service;

import com.ildarado.mimimimetr.domain.Cat;
import com.ildarado.mimimimetr.repos.CatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class CatService {

    private final CatRepo catRepo;

    Random random = new Random();
    boolean isFirst = true;
    List<Cat> allCats;

    public CatService(CatRepo catRepo) {
        this.catRepo = catRepo;
        allCats = catRepo.findAll();

    }

    public boolean addCat(Cat cat) {
        Cat catFromDB = catRepo.findByName(cat.getName());

        if (catFromDB != null)
            return false;

        catRepo.save(cat);
        return true;
    }

    public Iterable<Cat> findAllCat(){
        return catRepo.findAll();
    }

    public Iterable<Cat> getWinners() {
        List<Cat> winners = catRepo.findTop10ByOrderByVoicesCountDesc();
        int pos = 1;
        for (Cat c : winners){
            c.setPosition(pos++);
            catRepo.save(c);
        }
        return winners;
    }

    public Cat getRandomCat() {
        if (isFirst){
            allCats = catRepo.findAll();
            isFirst = false;
        }
        Cat cat;
        if (allCats.size() != 0) {
            int index = random.nextInt(allCats.size());
            cat = allCats.get(index);
            cat.setName(cat.getName() + " " + allCats.size());
            allCats.remove(index);
        } else {
            cat = new Cat("STOP CATS LIST");
            isFirst = true;
        }
        return cat;
    }

    public void saveCat(Cat cat) {
        catRepo.save(cat);
    }
}

package com.ildarado.mimimimetr.service;

import com.ildarado.mimimimetr.domain.Cat;
import com.ildarado.mimimimetr.repos.CatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CatService {
    @Autowired
    private CatRepo catRepo;

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
        return catRepo.findTop10ByOrderByVoicesCountDesc();
    }
}

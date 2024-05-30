package com.example.nezvon.service;

import com.example.nezvon.catRepa.CatRepo;
import com.example.nezvon.entyti.Cat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CatService {

    private final CatRepo catRepo;
    private static final Logger logger = LoggerFactory.getLogger(CatService.class);


    public CatService(CatRepo catRepo) {
        this.catRepo = catRepo;
    }

    @Cacheable(key = "#id", value = "cat")
    public Cat getCat(int id) {
        System.out.println("Fetching cat with id: " + id);
        return catRepo.findById(id).orElseThrow();
    }


}

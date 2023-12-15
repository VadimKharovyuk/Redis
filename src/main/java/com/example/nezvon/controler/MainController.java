package com.example.nezvon.controler;

import com.example.nezvon.catRepa.CatRepo;
import com.example.nezvon.controler.entyti.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.runtime.ObjectMethods;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CatRepo catRepo;
    private  final ObjectMapper objectMapper ;
 @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat){
     log.info("New row "+catRepo.save(cat)) ;

 }
 @SneakyThrows
 @GetMapping("/api/all")
    public   List<Cat> getAll(){
    return catRepo.findAll();

 }
 @GetMapping("/api")
    public Cat getCat(@RequestParam int id){
     return  catRepo.findById(id).orElseThrow();
 }
 @DeleteMapping("/api")
    public void deleteCat(@RequestParam int id){
     catRepo.deleteById(id);
 }
 @PutMapping
 public String change(@RequestBody Cat cat){
     if (!catRepo.existsById(cat.getId())){
         return "No such row" ;

     }
     log.info("New row "+catRepo.save(cat)) ;
     return catRepo.save(cat).toString();

 }

}

package com.example.nezvon.controler;

import com.example.nezvon.catRepa.CatRepo;
import com.example.nezvon.entyti.Cat;
import com.example.nezvon.service.CatService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final CatRepo catRepo;
    private final CatService catService;

 @PostMapping("/api/add")
    public void addCat(@RequestBody Cat cat){
     log.info("New row "+catRepo.save(cat)) ;

 }
 @SneakyThrows
 @GetMapping("/api/all")
    public   List<Cat> getAll(){
    return catRepo.findAll();

 }
 @GetMapping("/api/{id}")
 @Cacheable(key = "#id" ,value = "cat")
    public Cat getCat( @PathVariable int id){
     return  catService.getCat(id);
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

package com.example.nezvon.catRepa;

import com.example.nezvon.controler.entyti.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends JpaRepository<Cat,Integer> {

}

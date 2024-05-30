package com.example.nezvon.entyti;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@Table(name = "cats")
@AllArgsConstructor
@NoArgsConstructor
public class Cat implements Serializable {
    private static final long serialVersionUID = 3817784222026364680L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private int age;
    private int weight;

}

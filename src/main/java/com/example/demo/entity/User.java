package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//First layer to make after controller, is the entity.
@Entity
//Using Entity Annotation cuz this is an Entity.
@NoArgsConstructor
//Since we are using lambok, just using the Annotation is suffecient. If not, we have to make the constructor.
@AllArgsConstructor
@Data


public class User {
    @Id
    //Using ID cuz this is an Entity.
private int id;
private String name;
private String address;

}

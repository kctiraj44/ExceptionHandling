package com.example.exceptionhandling.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;


}

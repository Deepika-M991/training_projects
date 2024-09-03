package com.example.SpringDataJPA;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int level;

    public Employee(){
    }

     public Employee(String name, int level){
        this.name=name;
        this.level=level;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public String toString(){
        return "Employee ("+getId() +"," +getName()+","+getLevel()+")";
    }
}

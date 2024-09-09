package com.example.JavaPersistenceAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity

public class Book {

    private int id;
    private String title;
    private String author;
    private float price;

    //ALWAYS HAVE A DEFAULT CONSTRUCTOR FOR ENTITY
    public Book(){

    }

    public Book( String title, String author, float price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
    @Id
    //doubt
    @TableGenerator(name="bookstore_generator",
    table = "bookstore_table",
            pkColumnName = "gen_name",
            pkColumnValue = "book_id",
            valueColumnName = "gen_val",
            allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "bookstore_generator")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "{ id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
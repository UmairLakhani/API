package com.example.bbsydp_city.myapplication;

/**
 * Created by BBSYDP-CITY on 5/11/2017.
 */
public class Book {
    private int id, reviewer_id;
    private String name, author;

    public int getId() {
        return id;
    }

    public int getReviewer_id() {
        return reviewer_id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Book(int id, int reviewer_id, String name, String author) {
        this.id = id;
        this.reviewer_id = reviewer_id;
        this.name = name;
        this.author = author;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReviewer_id(int reviewer_id) {
        this.reviewer_id = reviewer_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

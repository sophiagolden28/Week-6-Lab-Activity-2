/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week.lab.activity2;

/**
 *
 * @author Sound Room
 */
public class Book implements BookInterface{

    private String title;
    private String author;
    boolean isBorrowed;

    public Book(String title, String author, boolean isBorrowed) {

        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;

    }

    //Implemented methods from BookInteface
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void borrowBook() {
        this.isBorrowed = true;
    }

    @Override
    public void returnBook() {
        this.isBorrowed = false;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Borrowed: " + isBorrowed;
    }

}

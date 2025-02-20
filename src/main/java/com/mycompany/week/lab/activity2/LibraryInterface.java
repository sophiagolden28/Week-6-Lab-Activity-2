/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week.lab.activity2;

/**
 *
 * @author Sound Room
 */
public interface LibraryInterface {

    public void addBook(Book newBook);

    public boolean borrowBook(String title);

    public boolean returnBook(String title);

    public String listBooks();

    public int countAvailableBooks();

    public int countBorrowedBooks();

    public Book searchByTitle(String title);

    public String searchByAuthor(String author);

}

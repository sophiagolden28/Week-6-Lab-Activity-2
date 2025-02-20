/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week.lab.activity2;

/**
 *
 * @author Sound Room
 */
public class LibraryMainDriver {

    public static void main(String[] args) {

        //library array creation with an initial length of 9 just so we have a base library to play around with
        Book[] libraryBooks = new Book[9];

        //create library object
        Library myLibrary = new Library(libraryBooks);

        //book creation 
        Book book1 = new Book("1984", "George Orwell", false);
        Book book2 = new Book("Jane Eyre", "Charlotte Bronte", false);
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", false);
        Book book4 = new Book("Little Women", "Louisa May Alcott", false);
        Book book5 = new Book("Pride and Prejudice", "Jane Austen", false);
        Book book6 = new Book("Around the Table", "Jonathan Case", false);
        Book book7 = new Book("Animal Farm", "George Orwell", false);
        Book book8 = new Book("Burmese Days", "George Orwell", false);
        Book book9 = new Book("Homage to Catalonia", "George Orwell", false);

        //Book adding test - yes i could have put this into the method but i'm not printing anything from there
        //just in case this turns into a gui someday
        myLibrary.addBook(book1);
        System.out.println(book1.getTitle() + " has been added to the library.");
        myLibrary.addBook(book2);
        System.out.println(book2.getTitle() + " has been added to the library.");
        myLibrary.addBook(book3);
        System.out.println(book3.getTitle() + " has been added to the library.");
        myLibrary.addBook(book4);
        System.out.println(book4.getTitle() + " has been added to the library.");
        myLibrary.addBook(book5);
        System.out.println(book5.getTitle() + " has been added to the library.");
        myLibrary.addBook(book6);
        System.out.println(book6.getTitle() + " has been added to the library.");
        myLibrary.addBook(book7);
        System.out.println(book7.getTitle() + " has been added to the library.");
        myLibrary.addBook(book8);
        System.out.println(book8.getTitle() + " has been added to the library.");
        myLibrary.addBook(book9);
        System.out.println(book9.getTitle() + " has been added to the library.");

        //Test borrow book part 1
        System.out.println("");
        if (myLibrary.borrowBook(book6.getTitle()) == true) {

            System.out.println(book6.getTitle() + " has been borrowed.");

        } else {

            System.out.println(book6.getTitle() + " cannot be borrowed at the time.");

        }

        //Test borrow book part 2 - try an already borrowed book
        if (myLibrary.borrowBook(book6.getTitle()) == true) {

            System.out.println(book6.getTitle() + " has been borrowed.");

        } else {

            System.out.println(book6.getTitle() + " cannot be borrowed at the time.");

        }
        
        //Test return book part 1
        System.out.println("");
        if (myLibrary.returnBook(book6.getTitle()) == true) {

            System.out.println(book6.getTitle() + " has been returned.");

        } else {

            System.out.println(book6.getTitle() + " cannot be returned at the time.");

        }

        //Test return book part 2 - try an already returned book
        if (myLibrary.returnBook(book6.getTitle()) == true) {

            System.out.println(book6.getTitle() + " has been returned.");

        } else {

            System.out.println(book6.getTitle() + " cannot be returned at the time.");

        }

        //List all the books in the library
        System.out.println("");
        System.out.println(myLibrary.listBooks());

        //Count available books and non-available books
        System.out.println("");
        System.out.println("Number of available books: " + myLibrary.countAvailableBooks());
        System.out.println("Number of borrowed books: " + myLibrary.countBorrowedBooks());

        //Search by Title test with title in the library
        System.out.println("");
        if (myLibrary.searchByTitle("Jane Eyre") != null) {
            System.out.println("Book found: ");
            System.out.println("    " + myLibrary.searchByTitle("Jane Eyre"));

        } else {

            System.out.println("That book was not found in the library.");
        }

        //Search by Title test with title not in the library
        System.out.println("");
        if (myLibrary.searchByTitle("The Hunger Games") != null) {
            System.out.println("Book found: ");
            System.out.println("    " + myLibrary.searchByTitle("The Hunger Games"));

        } else {

            System.out.println("The Hunger Games was not found in the library.");
        }

        //Search by Author test with author in library
        System.out.println("");
        if (myLibrary.searchByAuthor("George Orwell") != null) {
            System.out.println("Books by George Orwell:");
            System.out.println(myLibrary.searchByAuthor("George Orwell"));

        } else {

            System.out.println("No books by that author were found in the library.");
        }

        //Search by Author test with author not in library
        System.out.println("");
        if (myLibrary.searchByAuthor("Suzanne Collins") != null) {
            System.out.println("Books by Suzanne Collins:");
            System.out.println(myLibrary.searchByAuthor("Suzanne Collins"));

        } else {

            System.out.println("No books by Suzanne Collins were found in the library.");
        }

    }

}

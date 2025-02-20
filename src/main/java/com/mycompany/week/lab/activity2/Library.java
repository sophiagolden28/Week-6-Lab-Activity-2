/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week.lab.activity2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Sound Room
 */
public class Library implements LibraryInterface {

    //book array creation
    Book[] libraryArray;

    //constructor
    public Library(Book[] book) {

        //initializing the array to take in the book array
        libraryArray = book;

    }

    //to keep track of if the library is full
    public boolean isLibraryFull() {

        boolean full = false;

        //full spots to keep track
        int fullSpots = 0;

        //for each book in books
        for (BookInterface book : libraryArray) {
            //if there's a full spot
            if (book != null) {
                //increment the fullSpots variable
                fullSpots += 1;
            }
        }

        //if there are no empty spots
        if (fullSpots >= libraryArray.length) {
            full = true;
        }

        return full;

    }

    //ADD BOOK
    @Override
    public void addBook(Book newBook) {

        if (this.isLibraryFull() == true) {
            //modifying so that the library is never full
            double newLibraryLength;
            newLibraryLength = (int) Math.ceil(libraryArray.length * 1.5);
            libraryArray = Arrays.copyOf(libraryArray, (int) newLibraryLength);
        }

        //add the book to the first available spot
        for (int i = 0; i < libraryArray.length; i++) {

            //if spot at that spot is empty...
            if (libraryArray[i] == null) {
                //make the book that spot in the array
                libraryArray[i] = newBook;

                //kill the loop after adding the book
                break;
            }

        }

    }

    //BORROW BOOK
    @Override
    public boolean borrowBook(String title) {
        boolean isInLibrary = false;

        //index to keep track of where the book is so we know what to set isBorrowed to true of
        int index = 0;

        //if it's in the library - loop through the array
        for (int i = 0; i < libraryArray.length; i++) {

            if (libraryArray[i] != null) {

                //if there's an element with a title that matches the title
                if (title.equalsIgnoreCase(libraryArray[i].getTitle())) {

                    isInLibrary = true;
                    index = i;

                    //break just in case
                    break;

                }

            }

        }

        //if the book's in the library 
        if (isInLibrary == true) {

            //if it's alreaady checked out
            if (libraryArray[index].isBorrowed == true) {

                return false;

            } else {

                //if not we set isborrowed to true
                libraryArray[index].isBorrowed = true;
                return true;

            }

        }

        return false;

    }

    //RETURN BOOK
    @Override
    public boolean returnBook(String title) {

        boolean isInLibrary = false;

        //index to keep track of where the book is so we know what to set isBorrowed to true of
        int index = 0;

        //if it's in the library - loop through the array
        for (int i = 0; i < libraryArray.length; i++) {

            //if there's an element with a title that matches the title
            if (title.equalsIgnoreCase(libraryArray[i].getTitle())) {

                isInLibrary = true;
                index = i;

                //break just in case
                break;

            }

        }

        //if the book's in the library we say so and set is borrowed to false
        if (isInLibrary == true) {

            //if it's not checked out
            if (libraryArray[index].isBorrowed == false) {

                return false;

            } else {

                //if it's checked out we return it
                libraryArray[index].returnBook();
                return true;

            }

        }

        return false;

    }

    //LIST BOOKS
    @Override
    public String listBooks() {

        //start with a message
        String BigString = "Books in this library:";

        //for each book add the title and borrowed status etc
        for (Book libraryArray1 : libraryArray) {
            //if it's not null (that could happen if we increase the size of the library
            if (libraryArray1 != null) {
                BigString = BigString + "\n    " + libraryArray1.toString();
            }
        }

        //return it for use later
        return BigString;

    }

    //COUNT BOOKS NOT BORROWED
    @Override
    public int countAvailableBooks() {

        int numBooks = 0;

        for (int i = 0; i < libraryArray.length; i++) {

            if (libraryArray[i] != null) {

                if (libraryArray[i].isBorrowed == false) {
                    numBooks += 1;
                }

            }

        }

        return numBooks;

    }

    //SEARCH BY TITLE
    @Override
    public Book searchByTitle(String title) {

        //to keep track of where the book is in the index
        int index = 0;

        //to keep track if it's in the library
        boolean isInLibrary = false;

        //looping through the array to see if the book is there
        for (int i = 0; i < libraryArray.length; i++) {

            if (libraryArray[i] != null) {

                //if any one of the book titles matches the title given, it's in the library
                if (libraryArray[i].getTitle().equalsIgnoreCase(title)) {

                    index = i;
                    isInLibrary = true;
                    break;

                } else {
                    index = 0;
                }
            }

        }

        //if it's in the library we return the book
        if (isInLibrary == true) {

            return libraryArray[index];

        } else {

            //if not we return null
            return null;

        }
    }

    //SEARCH BY AUTHOR
    @Override
    public String searchByAuthor(String author) {
        String bigString = "";

        //make a new array list to loop through the library and get all the indices of the books together
        ArrayList<Book> worksByAuthor = new ArrayList<>(Arrays.asList());

        //to keep track of where the books are in the index
        //i have never used an array list before but it seems to work the way i want it to 
        //so i chose to use one
        ArrayList<Integer> indices = new ArrayList<>(Arrays.asList());

        //looping through the array to see if the book is there
        for (int i = 0; i < libraryArray.length; i++) {

            if (libraryArray[i] != null) {

                //if any one of the book titles matches the title given, it's in the library
                if (libraryArray[i].getAuthor().equalsIgnoreCase(author)) {

                    indices.add(i);

                }
            }

        }

        //if there's at least one book in the index list we add them all to the works
        if (indices.size() > 0) {

            for (int i = 0; i < indices.size(); i++) {

                worksByAuthor.add(libraryArray[indices.get(i)]);
                bigString = bigString + "\n" + worksByAuthor.get(i).getTitle();

            }

        } else {

            return null;

        }

        //return the string
        return bigString;

    }

    //COUNT BORROWED BOOKS
    @Override
    public int countBorrowedBooks() {

        int numBooks = 0;

        for (int i = 0; i < libraryArray.length; i++) {

            if (libraryArray[i] != null) {

                if (libraryArray[i].isBorrowed == true) {
                    numBooks += 1;
                }

            }

        }

        return numBooks;

    }

}

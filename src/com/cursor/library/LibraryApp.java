package com.cursor.library;

import com.cursor.library.utils.BooksKeeper;

import java.util.Scanner;

class LibraryApp {

    private BooksKeeper booksKeeper;
    private Scanner scanner;

    LibraryApp() {
        booksKeeper = BooksKeeper.getInstance();
        scanner = new Scanner(System.in);
    }

    void start() {
        System.out.println("Welcome to our brand new library app!");

        while (true) {
            System.out.println("\nTo borrow a book press 1");
            System.out.println("To find out which books you borrowed on a specific date press 2");
            System.out.println("To view all books you checked out press 3 ");
            System.out.println("To view all dates you borrowed books press 4");
            System.out.println("To quit press 5");
            String reply = scanner.nextLine();
            switch(reply){
                case "1":
                borrowBook();
                break;
                case "2":
                viewByDate();
                break;
                case "3":
                print(booksKeeper.retrieveAllBooks());
                break;
                case "4":
                print(booksKeeper.retrieveAllDates());
                break;
                case "5":
                print("GOODBYE!");
                System.exit(0);
                break;
                default:
                System.out.println("Sorry, your input has not been recognized. Please, try again");
                print("");
            }
        }
    }

    private void borrowBook() {
        System.out.println("Enter the name of the book you wish to borrow");
        booksKeeper.addBook(scanner.nextLine());
        System.out.println("Book added successfully.");
    }

    private void viewByDate() {
        System.out.println("Enter the date in format d-m-yyyy");
        String reply = scanner.nextLine();
        print(booksKeeper.retrieveBooksByDate(reply));
    }

    private void print(String str) {
        System.out.println("=========================");
        System.out.println(str);
        System.out.println("=========================");
    }
}

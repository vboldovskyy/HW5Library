package com.cursor.library.utils;

import java.text.SimpleDateFormat;
import java.util.*;

public class BooksKeeper {

    private Map<String, Set<Book>> bookMap;
    private static BooksKeeper booksKeeper;

    public static BooksKeeper getInstance() {
        if (booksKeeper == null) {
            booksKeeper = new BooksKeeper();
        }
        return booksKeeper;
    }

    private BooksKeeper() {

        bookMap = new HashMap<>();
        addBook("31-12-1999", new Book("Harry Potter and Hermiona`s Boobs"));
        addBook("7-7-2007", new Book("Head First Java"));
        addBook("7-7-2007", new Book("Fifty Shades of Gray"));
        addBook("30-6-2019", new Book("Short history of time"));
    }

    private boolean addBook(String key, Book book) {
        Set<Book> value = bookMap.get(key);
        if (value == null) {
            value = new HashSet<>();
        }
        value.add(book);
        bookMap.put(key, value);
        return true;
    }

    public boolean addBook(String book) {
        addBook(new SimpleDateFormat("d-M-yyyy").format(new Date()), new Book(book));
        return true;
    }

    public String retrieveAllDates() {
        return convertToString(bookMap.keySet());
    }

    public String retrieveAllBooks() {
        Set<Book> allBooks = new HashSet<>();
        for (Map.Entry<String, Set<Book>> entry : bookMap.entrySet()) {
            allBooks.addAll(entry.getValue());
        }
        return convertToString(allBooks);
    }

    public String retrieveBooksByDate(String dateKey) {
        Set<Book> booksOnADate = bookMap.get(dateKey);
        if (booksOnADate == null) {
            return "No books found for this date";
        }

        return convertToString(booksOnADate);
    }

    private String convertToString(Set set) {
        StringBuilder builder = new StringBuilder();
        for (Object a : set)
            builder.append("\n").append(a.toString());
        builder.append("\n");
        return builder.toString();

    }
}

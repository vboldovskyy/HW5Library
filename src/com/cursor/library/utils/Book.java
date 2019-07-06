package com.cursor.library.utils;

public class Book {

    private String name;

    Book(String name) {
        this.name = name;
    }

    public boolean equals(Object b) {
        if (b == null) {
            return false;
        }

        return (b instanceof Book) && name.equals(((Book) b).name);
    }

    public String toString() {
        return name;
    }

    public int hashCode() {
        return name.hashCode();
    }
}

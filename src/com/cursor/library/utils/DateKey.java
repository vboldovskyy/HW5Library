package com.cursor.library.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateKey {
    private final String date;
    //This class is a representation of an immutable single format date for usage as a key in a map.

    DateKey() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d-M-yyyy");
        this.date = sdf.format(now);
    }

    DateKey(String dateKey) {
        this.date = dateKey;
    }

    public String toString() {
        return date;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        return (o instanceof DateKey) && ((DateKey) o).date.equals(this.date);
    }

    public int hashCode() {
        return date.hashCode();
    }
}

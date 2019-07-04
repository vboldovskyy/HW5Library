package com.cursor.library.utils;

import java.util.Date;

public final class DateKey {
    private static final int YEAR_INCREMENT = 1900;
    private static final int MONTH_INCREMENT = 1;
    private final String date;
    //This class is a representation of an immutable single format date for usage as a key in a map.

    DateKey()
    {
        Date now = new Date();
        StringBuilder builder = new StringBuilder();
        builder.append(now.getDay()).append("-").append(now.getMonth()+MONTH_INCREMENT);
        builder.append("-").append(now.getYear()+YEAR_INCREMENT);
        this.date = builder.toString();
    }

    DateKey(String dateKey){
        this.date=dateKey;
    }

    public String toString(){
        return date;
    }

    public boolean equals (Object o)
    {
        if (o == null) return false;
        return (o instanceof DateKey) && ((DateKey)o).date.equals(this.date);
    }

    public int hashCode(){
        return date.hashCode();
    }
}

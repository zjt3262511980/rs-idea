package com.dto;

import java.util.ArrayList;
import java.util.Arrays;

public class Pundto {
    private String date;
    private int[] type;

    public Pundto(String date, int[] type) {
        this.date = date;
        this.type = type;
    }

    public Pundto() {
    }

    @Override
    public String toString() {
        return "Pundto{" +
                "date='" + date + '\'' +
                ", type=" + Arrays.toString(type) +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int[] getType() {
        return type;
    }

    public void setType(int[] type) {
        this.type = type;
    }
}

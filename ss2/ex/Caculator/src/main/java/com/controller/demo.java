package com.controller;

public class demo {
    int count;

    public int number(int l, int r) {
        for (int i = l; i <r ; i++) {
            if (i<9) {
                break;
            } else {
                String k = String.valueOf(i);
                if (k.charAt(0)==k.charAt(k.length()-1)) {
                    count++ ;
                }
            }
        }
        return count;
    }
}

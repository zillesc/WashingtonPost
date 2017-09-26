package com.example;

public class RefactoringDemo {

    public static String makeTwentyCopiesOfString(String string) {
        String newString = "";
        for (int i = 0; i < 20; i++) {
            // press alt-return while your mouse is on the += to convert into a StringBuilder
            newString += string;
        }
        return newString;
    }
}

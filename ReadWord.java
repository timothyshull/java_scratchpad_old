package com.company;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadWord {
    String word;
    BufferedReader in;

    ReadWord() {
        System.out.println("Constructing read word object");
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    void getInput() {
        try {
            word = in.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    void printReversedWord() {
        String reverse = new StringBuilder(word).reverse().toString();
        System.out.println(reverse);
    }
}

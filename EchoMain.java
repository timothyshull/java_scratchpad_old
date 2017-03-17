package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String message;

        System.out.print("Enter a message: ");
        System.out.flush();
        message = stdin.readLine();

        System.out.println("You entered: " + message);
    }
}

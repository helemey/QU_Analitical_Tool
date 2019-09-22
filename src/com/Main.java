package com;

import com.controller.Reader;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        System.out.println("Enter path of the file:");
        Scanner in = new Scanner(System.in);
        try {
            reader.read(in.next());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

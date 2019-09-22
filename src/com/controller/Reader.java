package com.controller;

import com.model.Constants;

import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {
    public void read(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath)); //"source/input.txt"
        int numberOfLines = Integer.parseInt(br.readLine());
        if (numberOfLines >= Constants.MAX_COUNT_OF_ALL_LINES || numberOfLines <= 0) {
            throw new Exception("Error: provided input file does not contain enough lines");
        }
        Parser parser = new Parser();
        parser.parse(br);
    }
}
package com.intelliarts.expensesmanagment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Buy buy = new Buy();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String command = reader.readLine();
            if (command.equals("exit")) {
                break;
            }
            buy.selectCommand(command);
        }

    }
}

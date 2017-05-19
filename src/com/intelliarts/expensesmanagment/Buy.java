package com.intelliarts.expensesmanagment;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static com.intelliarts.expensesmanagment.CurrencyConvertor.convert;

public class Buy {

    private String dateOfBuy;
    private double amountOfMoney;
    private String monetaryCurrency;
    private String nameOfBuy;
    DecimalFormat df = new DecimalFormat("####0.##");

    List<String> listOfBuy = new LinkedList<>();


    public void selectCommand(String command) {
        String typeCommand;
        String mas[] = command.split(" ");
        for (int i = 0; i < 1; i++) {
            typeCommand = mas[0];
            switch (typeCommand) {
                case "add":
                    addBuy(command);
                    break;
                case "list":
                    showList();
                    break;
                case "clear":
                    removeBuy(command);
                    break;
                case "total":
                    convertorCurrencyCode(command);
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }


    private void addBuy(String buy) {
        listOfBuy.add(buy);
        sortedList(listOfBuy);
        showList();
    }


    private void showList() {
        String dateOfBuy1 = " ";
        sortedList(listOfBuy);
        for (String entry : listOfBuy) {
            String mas[] = entry.split(" ", 5);

            for (int i = 0; i < mas.length; i++) {
                dateOfBuy = mas[1];
                amountOfMoney = Double.parseDouble(mas[2]);
                monetaryCurrency = mas[3];
                nameOfBuy = mas[4];
            }

            if (!dateOfBuy1.equals(dateOfBuy)) {
                System.out.println();
                System.out.println(dateOfBuy + " \n" + nameOfBuy + " " + df.format(amountOfMoney) + " " + monetaryCurrency);
                dateOfBuy1 = dateOfBuy;
            } else {
                System.out.println(nameOfBuy + " " + df.format(amountOfMoney) + " " + monetaryCurrency);
            }
        }
        System.out.println();
    }

    private void removeBuy(String command) {
        String dayOfBuy = " ";
        String mas1[] = command.split(" ");
        for (int i = 0; i < 1; i++) {
            dayOfBuy = mas1[1];
        }
        for (String element : listOfBuy) {
            String mas[] = element.split(" ");

            for (int i = 0; i < 1; i++) {
                dateOfBuy = mas[1];
            }

            if (dateOfBuy.equals(dayOfBuy)) {
                listOfBuy.remove(element);
            }
        }
        showList();
    }


    private void convertorCurrencyCode(String command) {
        String currency = " ";
        double sum = 0;

        String masCommand[] = command.split(" ");
        for (int i = 0; i < 1; i++) {
            currency = masCommand[1];
        }
        String currencyCode = currency.toUpperCase();
        for (String buy : listOfBuy) {
            String mas[] = buy.split(" ");

            for (int i = 0; i < mas.length; i++) {
                amountOfMoney = Double.parseDouble(mas[2]);
                monetaryCurrency = mas[3];
            }


            if (currencyCode.equals(monetaryCurrency)) {
                sum = sum + amountOfMoney;
            } else{
                double coversionRate = convert(monetaryCurrency, currencyCode);
                sum = sum + (amountOfMoney * coversionRate);
            }
        }
        System.out.println();
        System.out.println(df.format(sum) + " " + currencyCode + "\n");
    }


    private void sortedList(List<String> listOfBuy) {
        for (String entry : listOfBuy) {
            String mas[] = entry.split(" ");

            for (int i = 0; i < mas.length; i++) {
                dateOfBuy = mas[1];
            }

            Collections.sort(this.listOfBuy, new Comparator<String>() {

                public int compare(String dateOfBuy1, String dateOfBuy2) {
                    return dateOfBuy1.toString().compareTo(dateOfBuy2.toString());
                }
            });
        }
    }
}


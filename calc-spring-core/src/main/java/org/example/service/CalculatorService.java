package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {

    public static void selectMenu() {
        System.out.println("What kind of operation do you want to perform?\n" +
                "Enter number:\n1 - if it's addition,\n2 - if it's subtraction,\n" +
                "3 - if it's multiplication,\n4 - if it's division");
    }


    public static double addition(double num1, double num2) {
        return num1+num2;
    }

    public static double subtraction(double num1, double num2) {
        return num1-num2;
    }

    public static double multiplication(double num1, double num2) {
        return num1*num2;
    }

    public static double division(double num1, double num2) {
        return num1/num2;
    }
}

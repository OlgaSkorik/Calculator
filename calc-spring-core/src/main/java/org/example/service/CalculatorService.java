package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class CalculatorService {

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

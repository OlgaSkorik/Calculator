package org.example;

import org.example.reader.ConsoleReader;
import org.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Application {

    @Autowired
    private ConsoleReader consoleReader;

    public Application(ConsoleReader consoleReader) {
        this.consoleReader = consoleReader;
    }

    public void start() {
        boolean inWork = true;

        while (inWork) {
            System.out.println("Enter num1, please: ");
            double num1 = consoleReader.scannerD();

            System.out.println("Enter num2, please: ");
            double num2 = consoleReader.scannerD();

            CalculatorService.selectMenu();
            int selectOperation = consoleReader.scannerInt();
            switch (selectOperation) {
                case 1:
                    System.out.println("Result: " + CalculatorService.addition(num1, num2));
                    break;
                case 2:
                    System.out.println("Result: " + CalculatorService.subtraction(num1, num2));
                    break;
                case 3:
                    System.out.println("Result: " + CalculatorService.multiplication(num1, num2));
                    break;
                case 4:
                    System.out.println("Result: " + CalculatorService.division(num1, num2));
                    break;
                default:
                    System.out.println("This number is invalid!");
            }
            System.out.println("Do you want to do another operation? (yes/no)");
            String finalSelect = consoleReader.scannerStr();
            switch (finalSelect) {
                case "yes":
                    break;
                case "no":
                    inWork = false;
                    break;
                default:
                    System.out.println("This number is invalid!");
            }
        }
    }
}
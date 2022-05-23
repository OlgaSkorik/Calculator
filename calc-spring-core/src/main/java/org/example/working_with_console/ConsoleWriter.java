package org.example.working_with_console;


public class ConsoleWriter {

    public static void selectAuthOrReg() {
        System.out.println("What kind of operation do you want to perform?\n" +
                "Enter number:\n1 - if it's authentication,\n2 - if it's registration");
    }

    public static void enterName() {
        System.out.println("Enter you name, please: ");
    }

    public static void enterLogin() {
        System.out.println("Enter you login, please: ");
    }

    public static void enterPassword() {
        System.out.println("Enter you password, please: ");
    }

    public static void successfulReg() {
        System.out.println("Registration completed successfully!");
    }

    public static void successfulAuthOrReg() {
        System.out.println("Welcome to Calculator!");
    }

    public static void authFailed() {
        System.out.println("Access is denied!\nYou need to register!");
    }

    public static void regFailed() {
        System.out.println("Such user already exists!");
    }

    public static void selectMenu() {
        System.out.println("What kind of operation do you want to perform?\n" +
                "Enter number:\n1 - if it's addition,\n2 - if it's subtraction,\n" +
                "3 - if it's multiplication,\n4 - if it's division");
    }

    public static void messageIncorrect() {
        System.out.println("You have entered incorrect data!");
    }
}

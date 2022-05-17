package org.example.entity;

import org.example.dao.UserDao;
import org.example.working_with_console.ConsoleReader;
import org.example.service.CalculatorService;
import org.example.working_with_console.ConsoleWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Application {

    @Autowired
    private ConsoleReader consoleReader;
    @Autowired
    private UserDao userDao;

    private boolean inWork = false;

    public Application(ConsoleReader consoleReader, UserDao userDao) {
        this.consoleReader = consoleReader;
        this.userDao = userDao;
    }


    public void start() {
        ConsoleWriter.selectAuthOrReg();
        int selectOp = consoleReader.scannerInt();
        switch (selectOp) {
            case 1:
                auth();
                break;
            case 2:
                reg();
                break;
            default:
                ConsoleWriter.messageIncorrect();
        }

        while (inWork) {
            System.out.println("Enter num1, please: ");
            double num1 = consoleReader.scannerD();
            System.out.println("Enter num2, please: ");
            double num2 = consoleReader.scannerD();
            operation(num1, num2);
            anotherOperation();
        }
    }

    private void auth() {
        ConsoleWriter.enterLogin();
        String userLogin = consoleReader.scannerStr();
        ConsoleWriter.enterPassword();
        String userPassword = consoleReader.scannerStr();
        if (userDao.userIsExist(userLogin, userPassword)) {
            ConsoleWriter.successfulAuthOrReg();
            inWork = true;
        } else {
            ConsoleWriter.authFailed();
            registerOrNo();
        }
    }

    private  void registerOrNo() {
        System.out.println("Do you want to register? (yes/no)");
        String selectRegOrNo = consoleReader.scannerStr();
        switch (selectRegOrNo) {
            case "yes":
                reg();
                break;
            case "no":
                inWork = false;
                break;
            default:
                ConsoleWriter.messageIncorrect();
                registerOrNo();
        }
    }

    private void reg() {
        ConsoleWriter.enterName();
        String userNameReg = consoleReader.scannerStr();
        ConsoleWriter.enterLogin();
        String userLoginReg = consoleReader.scannerStr();
        ConsoleWriter.enterPassword();
        String userPasswordReg = consoleReader.scannerStr();
        if (!userDao.userIsExist(userLoginReg, userPasswordReg)) {
            userDao.add(new User(userDao.getStore().size() + 1,
                    userNameReg, userLoginReg, userPasswordReg));
            ConsoleWriter.successfulReg();
            auth();
            inWork = true;
        } else {
            ConsoleWriter.regFailed();

            auth();
        }
    }

    private void operation(double num1, double num2) {
        ConsoleWriter.selectMenu();
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
                ConsoleWriter.messageIncorrect();
        }
    }

    private void anotherOperation() {
        System.out.println("Do you want to do another operation? (yes/no)");
        String finalSelect = consoleReader.scannerStr();
        switch (finalSelect) {
            case "yes":
                break;
            case "no":
                inWork = false;
                break;
            default:
                ConsoleWriter.messageIncorrect();
                anotherOperation();
        }
    }
}
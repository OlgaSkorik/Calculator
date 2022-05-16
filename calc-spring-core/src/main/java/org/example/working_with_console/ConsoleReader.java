package org.example.working_with_console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleReader {

    @Autowired
    private Scanner scanner;

    public double scannerD() {
        return scanner.nextDouble();
    }

    public int scannerInt() {

        return scanner.nextInt();
    }

    public String scannerStr() {

        return scanner.next();
    }
}

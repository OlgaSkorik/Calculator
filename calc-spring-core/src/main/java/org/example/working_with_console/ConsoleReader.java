package org.example.working_with_console;


import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleReader {

    private Scanner scanner;

    public ConsoleReader(Scanner scanner) {
        this.scanner = scanner;
    }

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

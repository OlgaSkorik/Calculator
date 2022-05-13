package org.example.configuration;

import org.example.Application;
import org.example.reader.ConsoleReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;


@Configuration
@ComponentScan("org.example")
public class RootConfiguration {

    @Bean
    public Application application(ConsoleReader consoleReader) {
        return new Application(consoleReader);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public ConsoleReader consoleReader() {
        return new ConsoleReader();
    }
}

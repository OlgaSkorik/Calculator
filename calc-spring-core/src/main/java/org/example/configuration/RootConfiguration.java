package org.example.configuration;

import org.example.dao.UserDao;
import org.example.entity.Application;
import org.example.working_with_console.ConsoleReader;
import org.example.working_with_console.ConsoleWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.Scanner;


@Configuration
@ComponentScan("org.example")
public class RootConfiguration {

    @Bean
    public Application application(ConsoleReader consoleReader, UserDao userDao) {
        return new Application(consoleReader, userDao);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public ConsoleReader consoleReader() {
        return new ConsoleReader();
    }

    @Bean
    public ConsoleWriter consoleWriter() {
        return new ConsoleWriter();
    }

    @Bean
    public UserDao userDao() {
        return new UserDao();
    }
}

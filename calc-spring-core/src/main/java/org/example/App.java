package org.example;

import org.example.configuration.RootConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args ) {
        ApplicationContext app = new AnnotationConfigApplicationContext(RootConfiguration.class);
        Application application = app.getBean(Application.class);
        application.start();
    }
}

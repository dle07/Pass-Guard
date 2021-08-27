package com.passguard;

import com.passguard.Services.TerminalInterfaceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class Application implements CommandLineRunner {
    @Autowired
    private TerminalInterfaceImpl terminalInterfaceImpl;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        terminalInterfaceImpl.startProgram();
    }
}
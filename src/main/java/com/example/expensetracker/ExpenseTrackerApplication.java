package com.example.expensetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExpenseTrackerApplication.class, args);
    }

    @Bean
    public CommandLineRunner startupMessage() {
        return args -> {
            System.out.println("\nExpense Tracker is running!");
            System.out.println("🌐 Access it at: http://localhost:8080/expense-form.html\n");
        };
    }
}

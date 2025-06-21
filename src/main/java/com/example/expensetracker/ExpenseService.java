package com.example.expensetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repo;

    private final Map<String, Double> thresholds = Map.of(
            "Groceries", 10000.0,
            "Bills", 15000.0,
            "Entertainment", 8000.0
    );

    public List<Expense> getAll() {
        return repo.findAll();
    }

    public Expense addExpense(Expense e) {
        return repo.save(e);
    }

    public void clearAll() {
        repo.deleteAll();
    }

    public List<Expense> getAlerts() {
        return repo.findAll().stream()
                .filter(e -> thresholds.containsKey(e.getCategory()) &&
                             e.getAmount() > thresholds.get(e.getCategory()))
                .collect(Collectors.toList());
    }

    public Map<String, Double> getSummary(String period) {
        LocalDate today = LocalDate.now();
        LocalDate start;

        switch (period.toLowerCase()) {
            case "weekly":
                start = today.minusDays(7);
                break;
            case "monthly":
                start = today.minusDays(30);
                break;
            default:
                start = today.minusDays(1);
                break;
        }

        List<Expense> recent = repo.findByDateBetween(start, today);
        return recent.stream()
                .collect(Collectors.groupingBy(
                        Expense::getCategory,
                        Collectors.summingDouble(Expense::getAmount)
                ));
    }
}

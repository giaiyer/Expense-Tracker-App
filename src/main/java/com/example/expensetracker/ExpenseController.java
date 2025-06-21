package com.example.expensetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @GetMapping
    public List<Expense> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Expense addExpense(@RequestBody Expense expense) {
        expense.setDate(LocalDate.now());
        return service.addExpense(expense);
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearAll() {
        service.clearAll();
        return ResponseEntity.ok("All expenses cleared.");
    }

    @GetMapping("/alerts")
    public List<Expense> getAlerts() {
        return service.getAlerts();
    }

    @GetMapping("/summary")
    public Map<String, Double> getSummary(@RequestParam(defaultValue = "weekly") String period) {
        return service.getSummary(period);
    }
}

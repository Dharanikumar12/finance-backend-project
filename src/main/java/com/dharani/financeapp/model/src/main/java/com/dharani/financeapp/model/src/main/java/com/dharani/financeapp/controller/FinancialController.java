package com.dharani.financeapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.dharani.financeapp.model.FinancialRecord;
import com.dharani.financeapp.repository.FinancialRepository;

@RestController
@RequestMapping("/records")
public class FinancialController {

    private final FinancialRepository repo;

    public FinancialController(FinancialRepository repo) {
        this.repo = repo;
    }

    // Create record
    @PostMapping
    public FinancialRecord addRecord(@RequestBody FinancialRecord record) {
        return repo.save(record);
    }

    // Get all records
    @GetMapping
    public List<FinancialRecord> getAllRecords() {
        return repo.findAll();
    }

    // Delete record
    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        repo.deleteById(id);
        return "Deleted successfully";
    }
}

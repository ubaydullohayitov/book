package com.Westco.controller;


import com.Westco.model.Category;
import com.Westco.service.ServiceCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class ControllerCategory {

    private final ServiceCategory serviceCategory;

    public ControllerCategory(ServiceCategory serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    @PostMapping("/category")
    public ResponseEntity create(@RequestBody Category category) {
        Category category1 = serviceCategory.save(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/category")
    public ResponseEntity<?> update(@RequestBody Category category) {
        Category category1 = serviceCategory.save(category);
        return ResponseEntity.ok(category1);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Category category = serviceCategory.getOne(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/category")
    public ResponseEntity findAll(Pageable pageable) {
        Page<Category> page = serviceCategory.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        serviceCategory.delete(id);
        return ResponseEntity.ok("Berilgan kategoriya o'chirildi");
    }
}


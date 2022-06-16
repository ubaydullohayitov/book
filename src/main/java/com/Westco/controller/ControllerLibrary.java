package com.Westco.controller;

import com.Westco.model.Library;
import com.Westco.model.Student;
import com.Westco.repository.RepositoryLibrary;
import com.Westco.service.ServiceLibrary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerLibrary {

    private final ServiceLibrary serviceLibrary;

    public ControllerLibrary(ServiceLibrary serviceLibrary) {
        this.serviceLibrary = serviceLibrary;
    }
    @GetMapping("/library/{id}")
    public ResponseEntity getAll(@PathVariable Long id) {
        Library library1 = serviceLibrary.getOne(id);
        return ResponseEntity.ok(library1);
    }

    @GetMapping("/library")
    public ResponseEntity findAll(Pageable pageable) {
        Page<Library> page = serviceLibrary.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/library/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        serviceLibrary.delete(id);
        return ResponseEntity.ok("Berilgan kutubxona o'chirildi");
    }
    @PostMapping("/library")
    public ResponseEntity create(@RequestBody Library library) {
        Library library1 = serviceLibrary.save(library);
        return ResponseEntity.ok(library1);
    }

    @PutMapping("/library")
    public ResponseEntity<?> update(@RequestBody Library library) {
        Library library1 = serviceLibrary.save(library);
        return ResponseEntity.ok(library1);
    }
}

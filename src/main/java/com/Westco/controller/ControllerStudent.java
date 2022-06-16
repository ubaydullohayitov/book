package com.Westco.controller;

import com.Westco.model.Student;
import com.Westco.service.ServiceStudent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerStudent {

    private final ServiceStudent serviceStudent;

    public ControllerStudent(ServiceStudent serviceStudent) {
        this.serviceStudent = serviceStudent;
    }

    @PostMapping("/student")
    public ResponseEntity create(@RequestBody Student student) {
        Student student1 = serviceStudent.save(student);
        return ResponseEntity.ok(student1);
    }

    @PutMapping("/student")
    public ResponseEntity<?> update(@RequestBody Student student) {
        Student student1 = serviceStudent.save(student);
        return ResponseEntity.ok(student1);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Student student1 = serviceStudent.getOne(id);
        return ResponseEntity.ok(student1);
    }

    @GetMapping("/student")
    public ResponseEntity findAll(Pageable pageable) {
        Page<Student> page = serviceStudent.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        serviceStudent.delete(id);
        return ResponseEntity.ok("Berilgan student o'chirildi");
    }
}

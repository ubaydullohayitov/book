package com.Westco.controller;

import com.Westco.model.Course;
import com.Westco.service.ServiceCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ControllerCourse {

    private final ServiceCourse serviceCourse;

    public ControllerCourse(ServiceCourse serviceCourse) {
        this.serviceCourse = serviceCourse;
    }

    @PostMapping("/course")
    public ResponseEntity create(@RequestBody Course course) {
        Course courses = serviceCourse.save(course);
        return ResponseEntity.ok(courses);
    }

    @PutMapping("/course")
    public ResponseEntity<?> update(@RequestBody Course course) {
        Course course1 = serviceCourse.save(course);
        return ResponseEntity.ok(course1);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity getAll(@PathVariable Long id) {
        Course course = serviceCourse.getOne(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/course")
    public ResponseEntity findAll(Pageable pageable) {
        Page<Course> page = serviceCourse.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        serviceCourse.delete(id);
        return ResponseEntity.ok("Berilgan Kurs o'chirildi");
    }

}

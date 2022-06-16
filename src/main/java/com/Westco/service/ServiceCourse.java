package com.Westco.service;

import com.Westco.model.Category;
import com.Westco.model.Course;
import com.Westco.repository.RepositoryCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCourse {

    private final RepositoryCourse repositoryCourse;

    public ServiceCourse(RepositoryCourse repositoryCourse) {
        this.repositoryCourse = repositoryCourse;
    }

    public Course save(Course course) {
        Course course1 = repositoryCourse.save(course);
        return course;
    }

    public Course getOne(Long id) {
        Optional<Course> optionalCourse = repositoryCourse.findById(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            return course;
        }
        return null;
    }
    public Page<Course> findAll(Pageable pageable) {
        Page<Course> page = repositoryCourse.findAll(pageable);
        return page;
    }

    public void delete(Long id) {
        repositoryCourse.deleteById(id);
    }
}

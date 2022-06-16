package com.Westco.repository;

import com.Westco.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCourse extends JpaRepository<Course, Long> {
}

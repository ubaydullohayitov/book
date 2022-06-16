package com.Westco.service;

import com.Westco.model.Category;
import com.Westco.model.Student;
import com.Westco.repository.RepositoryStudent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServiceStudent {

    private final RepositoryStudent repositoryStudent;

    public ServiceStudent(RepositoryStudent repositoryStudent) {
        this.repositoryStudent = repositoryStudent;
    }

    public Student save(Student student) {
        Student category1 = repositoryStudent.save(student);
        return category1;
    }

    @Transactional(readOnly = true)
    public Student getOne(Long id) {
        Optional<Student> optionalStudent = repositoryStudent.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return student;
        }
        return null;
    }

    public Page<Student> findAll(Pageable pageable) {
        Page<Student> page = repositoryStudent.findAll(pageable);
        return page;
    }

    public void delete(Long id) {
        repositoryStudent.deleteById(id);
    }
}

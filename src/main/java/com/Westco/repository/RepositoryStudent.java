package com.Westco.repository;

import com.Westco.model.Student;
import org.hibernate.type.descriptor.sql.LongVarcharTypeDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryStudent extends JpaRepository<Student, Long> {
}

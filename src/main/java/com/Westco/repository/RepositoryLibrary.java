package com.Westco.repository;

import com.Westco.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLibrary extends JpaRepository<Library, Long> {
}

package com.Westco.service;

import com.Westco.model.Category;
import com.Westco.repository.RepositoryCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServiceCategory {

    private final RepositoryCategory repositoryCategory;

    public ServiceCategory(RepositoryCategory repositoryCategory) {
        this.repositoryCategory = repositoryCategory;
    }

    public Category save(Category category) {
        Category category1 = repositoryCategory.save(category);
        return category1;
    }

    @Transactional(readOnly = true)
    public Category getOne(Long id) {
        Optional<Category> optionalCategory = repositoryCategory.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            return category;
        }
        return null;
    }

    public Page<Category> findAll(Pageable pageable) {
        Page<Category> page = repositoryCategory.findAll(pageable);
        return page;
    }

    public void delete(Long id) {
        repositoryCategory.deleteById(id);
    }
}


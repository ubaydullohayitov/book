package com.Westco.service;

import com.Westco.model.Library;
import com.Westco.repository.RepositoryLibrary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServiceLibrary {

    private final RepositoryLibrary repositoryLibrary;

    public ServiceLibrary(RepositoryLibrary repositoryLibrary) {
        this.repositoryLibrary = repositoryLibrary;
    }

    public Library save(Library library) {
        Library library1 = repositoryLibrary.save(library);
        return library1;
    }

    @Transactional(readOnly = true)
    public Library getOne(Long id) {
        Optional<Library> optionalLibrary = repositoryLibrary.findById(id);
        if (optionalLibrary.isPresent()) {
            Library library = optionalLibrary.get();
            return library;
        }
        return null;
    }

    public Page<Library> findAll(Pageable pageable) {
        Page<Library> page = repositoryLibrary.findAll(pageable);
        return page;
    }

    public void delete(Long id) {
        repositoryLibrary.deleteById(id);
    }
}

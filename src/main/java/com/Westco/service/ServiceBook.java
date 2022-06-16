package com.Westco.service;

import com.Westco.model.Book;
import com.Westco.model.Library;
import com.Westco.repository.RepositoryBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServiceBook {

    private final RepositoryBook repositoryBook;

    public ServiceBook(RepositoryBook repositoryBook) {
        this.repositoryBook = repositoryBook;
    }

    public Book save(Book book) {
        Book book1 = repositoryBook.save(book);
        return book1;
    }

    @Transactional(readOnly = true)
    public Book getOne(Long id) {
        Optional<Book> optionalBook = repositoryBook.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            return book;
        }
        return null;
    }

    public Page<Book> findAll(Pageable pageable) {
        Page<Book> page = repositoryBook.findAll(pageable);
        return page;
    }

    public void delete(Long id) {
        repositoryBook.deleteById(id);
    }
}

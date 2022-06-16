package com.Westco.controller;

import com.Westco.model.Book;
import com.Westco.service.ServiceBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@RestController
@RequestMapping("/api")
public class ControllerBook {

   private final ServiceBook serviceBook;

    public ControllerBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }

    @GetMapping("/book/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
//        log.debug("GET request to get a book with id : {}", id);
        System.out.println("Received GET request to get a book with id : " + id);
        Book book1 = serviceBook.getOne(id);
        return ResponseEntity.ok(book1);
    }   

    @GetMapping("/book")
    public ResponseEntity findAll(Pageable pageable) {
        Page<Book> page = serviceBook.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        serviceBook.delete(id);
        return ResponseEntity.ok("Berilgan book o'chirildi");
    }
    @PostMapping("/book")
    public ResponseEntity create(@RequestBody Book book) {
        Book book1 = serviceBook.save(book);
        return ResponseEntity.ok(book1);
    }

    @PutMapping("/book")
    public ResponseEntity<?> update(@RequestBody Book book) {
        Book book1 = serviceBook.save(book);
        return ResponseEntity.ok(book1);
    }
}

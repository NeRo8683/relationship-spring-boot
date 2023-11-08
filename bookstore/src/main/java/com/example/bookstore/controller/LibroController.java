/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bookstore.controller;



import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author a
 */
@RestController
@RequestMapping("/book")
public class LibroController {

    @Autowired
    private BookService bookService;    
    
    @GetMapping("/get")
    public ResponseEntity<Page<Book>> findAll(Pageable pageable) {
        Page<Book> books = bookService.findAll(pageable);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/post")
    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book, @PathVariable Integer id) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        return bookService.deleteBook(id);
    }

}

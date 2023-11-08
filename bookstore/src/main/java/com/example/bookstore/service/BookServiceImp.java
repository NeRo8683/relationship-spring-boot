/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Bookstore;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.BookstoreRepository;
import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookstoreRepository bookstoreRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public ResponseEntity<Book> saveBook(Book book) {
        Optional<Bookstore> bookstoreOptional = bookstoreRepository.findById(book.getBookstore().getId());

        if (!bookstoreOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        book.setBookstore(bookstoreOptional.get());
        Book bookSave = bookRepository.save(book);
        URI ubicación = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookSave.getId()).toUri();
        return ResponseEntity.created(ubicación).body(bookSave);
    }

    @Override
    public ResponseEntity<Book> findById(Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (!bookOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(bookOptional.get());
    }

    @Override
    public ResponseEntity<Book> updateBook(Integer id, Book book) {
        Optional<Bookstore> bookstoreOptional = bookstoreRepository.findById(book.getBookstore().getId());

        if (!bookstoreOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Book> bookOptional = bookRepository.findById(id);

        if (!bookOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Book bookExistente = bookOptional.get();

        bookExistente.setBookstore(bookstoreOptional.get());

        bookExistente.setName(book.getName());

        bookRepository.save(bookExistente);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteBook(Integer id) {
        Optional<Book> libroOptional = bookRepository.findById(id);

        if (!libroOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        bookRepository.delete(libroOptional.get());
        return ResponseEntity.noContent().build();
    }
}

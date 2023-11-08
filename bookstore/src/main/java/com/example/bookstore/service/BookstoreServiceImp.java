/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Bookstore;
import com.example.bookstore.repository.BookstoreRepository;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author a
 */
@Service
public class BookstoreServiceImp implements BookstoreService {

    @Autowired
    private BookstoreRepository bookstoreRepository;

    @Override
    public Page<Bookstore> findAll(Pageable pageable) {
        return bookstoreRepository.findAll(pageable);
    }

    @Override
    public Bookstore saveBookstore(Bookstore bookstore) {
        return bookstoreRepository.save(bookstore);
    }

    @Override
    public ResponseEntity<Bookstore> updateBookstore(Integer id, Bookstore bookstore) {
        Optional<Bookstore> bookstoreOptional = bookstoreRepository.findById(id);

        if (!bookstoreOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Bookstore bookstoreExistente = bookstoreOptional.get();
        bookstoreExistente.setName(bookstore.getName());

        updateBookstore(bookstoreExistente, bookstore.getBooks());
        Bookstore bookstoreUpdate = bookstoreRepository.save(bookstoreExistente);

        return ResponseEntity.ok(bookstoreUpdate);
    }

    // Método auxiliar para actualizar la relación con los libros asociados
    private void updateBookstore(Bookstore bookstoreExistente, Set<Book> newBooks) {
        // Borra los libros existentes que no están en la lista de nuevos libros
        Iterator<Book> bookIterator = bookstoreExistente.getBooks().iterator();
        while (bookIterator.hasNext()) {

            Book bookExistente = bookIterator.next();
            if (!newBooks.contains(bookExistente)) {
                bookIterator.remove();
            }
        }

        for (Book newBook : newBooks) {
            if (!bookstoreExistente.getBooks().contains(newBook)) {
                bookstoreExistente.getBooks().add(newBook);
                newBook.setBookstore(bookstoreExistente);
            }
        }
    }

    @Override
    public ResponseEntity<Bookstore> findById(Integer id) {
        Optional<Bookstore> bookstoreOptional = bookstoreRepository.findById(id);

        if (!bookstoreOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(bookstoreOptional.get());
    }

    @Override
    public ResponseEntity<Void> deleteBookstore(Integer id) {
        Optional<Bookstore> bookstoreOptional = bookstoreRepository.findById(id);

        if (!bookstoreOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        bookstoreRepository.delete(bookstoreOptional.get());
        return ResponseEntity.noContent().build();
    }

}

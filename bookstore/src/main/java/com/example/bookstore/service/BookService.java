/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author a
 */
public interface BookService {

    Page<Book> findAll(Pageable pageable);
//    Page<Book> listarLibros(Pageable pageable);
    ResponseEntity<Book> saveBook(Book book);
    ResponseEntity<Book> findById(Integer id);
    ResponseEntity<Book> updateBook(Integer id, Book book);
    ResponseEntity<Void> deleteBook(Integer id);

}

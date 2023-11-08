/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bookstore.service;

import com.example.bookstore.model.Bookstore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author a
 */

public interface BookstoreService {

    Page<Bookstore> findAll(Pageable pageable);
    Bookstore saveBookstore(Bookstore bookstore);
    ResponseEntity<Bookstore> updateBookstore(Integer id, Bookstore boostore);
    ResponseEntity<Bookstore> findById(Integer id);
    ResponseEntity<Void> deleteBookstore(Integer id);
}

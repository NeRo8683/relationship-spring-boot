/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bookstore.controller;

import com.example.bookstore.model.Bookstore;
import com.example.bookstore.service.BookstoreService;
import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author a
 */
@RestController
@RequestMapping("/bookstore")
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    @GetMapping("/get")
    public ResponseEntity<Page<Bookstore>> findAll(Pageable pageable) {
        Page<Bookstore> bookstores = bookstoreService.findAll(pageable);
        return ResponseEntity.ok(bookstores);
    }

    @PostMapping("/post")
    public ResponseEntity<Bookstore> saveBookstore(@Valid @RequestBody Bookstore bookstore) {
        Bookstore bookstoreSave = bookstoreService.saveBookstore(bookstore);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(bookstoreSave.getId()).toUri();
        
        return ResponseEntity.created(ubicacion).body(bookstoreSave);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Bookstore> updateBookstore(@PathVariable Integer id, @Valid @RequestBody Bookstore bookstore) {
        return bookstoreService.updateBookstore(id, bookstore);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Bookstore> findById(@PathVariable Integer id) {
        return bookstoreService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookstore(@PathVariable Integer id) {
        return bookstoreService.deleteBookstore(id);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.bookstore.repository;

import com.example.bookstore.model.Bookstore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author a
 */
@Repository
public interface BookstoreRepository extends JpaRepository<Bookstore, Integer> {

}

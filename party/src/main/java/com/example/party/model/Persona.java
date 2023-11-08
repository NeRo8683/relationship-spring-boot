/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.party.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author a
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private long id;

    private String name;

    private int age;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<Skills> habilidades = new HashSet<>();

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "personas_fiestas", joinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "persona_id"), inverseJoinColumns = @JoinColumn(name = "fiesta_id", referencedColumnName = "fiesta_id"))
    private Set<Party> fiestas = new HashSet<>();

}

package com.twineo.start.infrastructure.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "types")
public class TypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ou AUTO
    @Column(nullable = false, updatable = false)
    private Long id;
    String name;
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String password;

}

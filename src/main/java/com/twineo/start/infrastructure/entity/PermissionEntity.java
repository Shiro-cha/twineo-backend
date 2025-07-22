package com.twineo.start.infrastructure.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "permissions")
public class PermissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ou AUTO
    @Column(nullable = false, updatable = false)
    private Long id;
    String scope;
    String description;

}

package com.twineo.start.infrastructure.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class TypeEntity {
    @Id
    String id;
    String name;
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String password;

    public TypeEntity(){
        this.id= UUID.randomUUID().toString();
    }
}

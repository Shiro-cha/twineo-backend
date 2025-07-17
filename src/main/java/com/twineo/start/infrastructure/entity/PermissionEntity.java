package com.twineo.start.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "permissions")
public class PermissionEntity {
    @Id
    String id;
    String scope;
    String description;

    public PermissionEntity(){
        this.id= UUID.randomUUID().toString();
    }
}

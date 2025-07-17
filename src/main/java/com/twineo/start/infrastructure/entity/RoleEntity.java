package com.twineo.start.infrastructure.entity;

import com.twineo.start.domain.model.Permission;
import jakarta.persistence.Column;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    String id;

    String name;
    String description;

    @ManyToMany
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private java.util.List<PermissionEntity> permissions;

    public RoleEntity() {
        this.id = UUID.randomUUID().toString();
    }
}


package com.twineo.start.infrastructure.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "machines")
public class MachineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ou AUTO
    @Column(nullable = false, updatable = false)
    private Long id;

    String name;
    String ip;
    String username;
    String password;
    String key;
    @ManyToOne
    @JoinColumn(name="type_id")
    TypeEntity type;

}

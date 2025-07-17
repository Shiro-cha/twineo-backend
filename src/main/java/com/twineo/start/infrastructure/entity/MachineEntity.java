package com.twineo.start.infrastructure.entity;

import com.twineo.start.domain.model.Type;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "machines")
public class MachineEntity {
    @Id
    String id;
    String name;
    String ip;
    String user;
    String password;
    String key;
    @ManyToOne
    @JoinColumn(name="type_id")
    Type type;

    public MachineEntity(){
        this.id= UUID.randomUUID().toString();
    }
}

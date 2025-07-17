package com.twineo.start.infrastructure.entity;

import com.twineo.start.domain.model.Machine;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "users")
public class TaskEntity {
    @Id
    String id;
    String name;
    String command;
    String status;
    Date executionTime;
    @ManyToOne
    @JoinColumn(name="machine_id")
    Machine machine;

    public TaskEntity(){
        this.id= UUID.randomUUID().toString();
    }
}

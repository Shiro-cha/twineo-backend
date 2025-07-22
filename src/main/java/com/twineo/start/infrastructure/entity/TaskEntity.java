package com.twineo.start.infrastructure.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String name;
    private String command;
    private String status;
    private Date executionTime;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private MachineEntity machine;

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCommand() {
        return command;
    }

    public String getStatus() {
        return status;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public MachineEntity getMachine() {
        return machine;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public void setMachine(MachineEntity machine) {
        this.machine = machine;
    }
}

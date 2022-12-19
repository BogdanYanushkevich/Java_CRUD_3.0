package com.bogdan_yanushkevich.javacore.crud.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "specialties", schema = "public", catalog = "crudDb")
public class Specialty {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "specialty_id", nullable = false)
    Long id;
    @Enumerated
    @Column(name = "specialty_status", nullable = false, length = 10)
    private Status status;
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    public Specialty(Long id, Status status, String name) {
        this.id = id;
        this.status = status;
        this.name = name;
    }

    public Specialty() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty = (Specialty) o;
        return status == specialty.status && name.equals(specialty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, name);
    }

    @Override
    public String toString() {
        return "Specialty | " +
                "\tID: " + getId() + " \t| " +
                "Name: " + getName() + " \t| " +
                "Status: " + getStatus();
    }
}

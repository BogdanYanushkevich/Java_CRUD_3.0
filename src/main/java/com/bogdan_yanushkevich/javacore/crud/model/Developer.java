package com.bogdan_yanushkevich.javacore.crud.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "developers", schema = "public", catalog = "crudDb")
public class Developer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "developer_id", nullable = false)
    Long id;

    @Column(name = "firstname", nullable = false, length = 30)
    private String firstName;

    @Column(name = "lastname", nullable = false, length = 30)
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "skills_atribute",
            joinColumns = @JoinColumn(name = "developer_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills = new ArrayList<>();
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "specialty_id", referencedColumnName = "specialty_id")
    private Specialty specialty;
    @Enumerated
    @Column(name = "developer_status", nullable = false, length = 10)
    private Status status;

    public Developer(Long Id, String firstName, String lastName, Specialty specialty, List<Skill> skills, Status status) {
        setId(id);
        setFirstName(firstName);
        this.lastName = lastName;
        setSpecialty(specialty);
        addSkills(skills);
        setStatus(status);
    }

    public Developer() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {

        return skills;
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void addSkills(List<Skill> skills) {

        this.skills = skills;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return firstName.equals(developer.firstName) && lastName.equals(developer.lastName) && skills.equals(developer.skills) && specialty.equals(developer.specialty) && status == developer.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, skills, specialty, status);
    }

    @Override
    public String toString() {
        return "Developer | " +
                "\tID: " + getId() + " \t| " +
                "\tName: " + getFirstName() + " \t| " +
                "\tLastName: " + getLastName() + " \t| " +
                "\tSkills: " + getSkills() + " \t| " +
                "\tSpecialty: " + getSpecialty() + " \t| " +
                "\tStatus: " + getStatus();
    }
}

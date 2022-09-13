package com.example.les11model.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="docenten")
public class Docent {
    @Id
    @GeneratedValue

    private Long id;

    private String firstname;

    private String lastname;

    private LocalDate dob;

    @OneToMany(mappedBy = "docent")
    @JsonIgnore
    List<Cursus> cursussen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Cursus> getCursussen() {
        return cursussen;
    }
}

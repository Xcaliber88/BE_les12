package com.example.les11model.model;

import javax.persistence.*;

@Entity
@Table(name="lessen")
public class Les {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String thema;

    @ManyToOne
    @JoinColumn(name="cursus_id")
    Cursus cursus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThema() {
        return thema;
    }

    public void setThema(String thema) {
        this.thema = thema;
    }
}

package com.Westco.jwt.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private Status name;

    public Role(){
    }
    public Role(Long id, Status name){
        this.id = id;
        this.name = name;
    }
    public void add(Role role){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getName() {
        return name;
    }

    public void setName(Status name) {
        this.name = name;
    }
}

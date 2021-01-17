package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter


@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Collection<Account> accounts;

    public Role(){

    }

    public Role(String role) {
        super();
        this.role = role;
    }
}

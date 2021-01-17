package com.example.demo.entity;


import lombok.Getter;

import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter

@Entity
@Table(name = "accounts", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "accounts_roles",  // create new accounts_roles table
            joinColumns = @JoinColumn(
                    // lien ket voi nhau qua khoa ngoai account_id, tham chieu cot ID cua account
                    name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Collection< Role > roles;

    @OneToMany(mappedBy = "account")
    private Collection<Post> posts;

    public Account(){

    }

    public Account(String firstName, String lastName, String email, String password, Collection < Role > roles) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}

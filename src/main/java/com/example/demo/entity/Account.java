package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Getter
@Setter

@Entity
@Table(name = "accounts", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accounts_id")
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "*Please provide your first name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @Column(name = "password", nullable = false)
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "accounts_roles",  // create new accounts_roles table
            joinColumns = @JoinColumn(
                    // lien ket voi nhau qua khoa ngoai accounts_id
                    name = "accounts_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id"))
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

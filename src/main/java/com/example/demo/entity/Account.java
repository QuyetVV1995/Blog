package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username", length = 255, nullable = false)
    private String username;

    @Column(name = "encryted_password", length = 128, nullable = false)
    private String encryted_password;

    @Column(name = "active", length = 1, nullable = false)
    private boolean active;

    @Column(name = "user_role", length = 20, nullable = false)
    private String user_role;
}

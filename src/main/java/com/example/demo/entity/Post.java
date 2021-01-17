package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false, length = 300)
    private String title;

    @Column(name = "intro", nullable = false, length = 300)
    private String intro;

    @Column(name = "created_at")
    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    @NotNull
    private Account account;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Collection<Comment> comments;


}

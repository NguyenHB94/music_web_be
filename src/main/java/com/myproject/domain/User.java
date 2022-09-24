package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String password;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Column(name = "perferences")
    private String perferences;

    @Column(name = "remember_token")
    private String rememberToken;

    @Column(name = "create_at")
    private Long createAt;

    @Column(name = "update_at")
    private Long updateAt;

    @OneToOne
    @JsonIgnoreProperties(value = {"artist", "albums", "playlist", "song"}, allowSetters = true)
    @JoinColumn(name = "user_image")
    private Image image;

    @JsonIgnoreProperties(value = {"image"}, allowSetters = true)
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Playlist> playlist;

    @JsonIgnoreProperties(value = {"song"},allowSetters = true)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Interaction> interaction;
}

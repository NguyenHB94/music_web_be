package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rules")
    private String rules;

    @Column(name = "create_at")
    private Long createAt;

    @Column(name = "update_at")
    private Long updateAt;

    @OneToOne
    @JsonIgnoreProperties(value = {"artist", "albums", "song", "user"}, allowSetters = true)
    @JoinColumn(name = "playlist_image")
    private Image image;
    @ManyToOne
    @JsonIgnoreProperties(value = {"image", "interaction"}, allowSetters = true)
    @JoinColumn(name = "user_id")
    private User user;

}
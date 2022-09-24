package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    private String path;

    @JsonIgnoreProperties(value = {"artist", "album", "interactions", "playlistsongs"}, allowSetters = true)
    @OneToOne
    private Song song;

    @JsonIgnoreProperties(value = {"songs", "artist"}, allowSetters = true)
    @OneToOne
    private Album album;

    @JsonIgnoreProperties(value = {"user"},allowSetters = true)
    @OneToOne
    private Playlist playlist;


    @JsonIgnoreProperties(value = {"songs", "albums"}, allowSetters = true)
    @OneToOne
    private Artist artist;

    @JsonIgnoreProperties(value = {"playlists", "interactions"}, allowSetters = true)
    @OneToOne
    private User user;

}

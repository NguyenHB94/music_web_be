package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "album")
public class Album{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_at")
    private Long createAt;

    @Column(name = "update_at")
    private Long updateAt;

    @OneToOne
    @JsonIgnoreProperties(value = {"artist", "song", "playlist", "user"}, allowSetters = true)
    @JoinColumn(name = "album_image")
    private Image image;

    @JsonIgnoreProperties(value = {"image", "artist", "interaction", "playlistSongs"}, allowSetters = true)
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Song> songs = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = {"image", "songs"},allowSetters = true)
    @JoinColumn(name = "artist_id")
    private Artist artist;

}

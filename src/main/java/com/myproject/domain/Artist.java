package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "artists")
public class Artist{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "create_at")
    private Long createAt;

    @Column(name = "update_at")
    private Long updateAt;

    @OneToOne
    @JoinColumn(name = "artist_image")
    @JsonIgnoreProperties(value = {"album", "playlist", "song", "user"}, allowSetters = true)
    private Image image;

    @JsonIgnoreProperties(value = {"image", "album", "interaction", "playlistSongs"}, allowSetters = true)
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Song> songs = new HashSet<>();

    @JsonIgnoreProperties(value = {"image", "songs"}, allowSetters = true)
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Album> albums = new HashSet<>();
}

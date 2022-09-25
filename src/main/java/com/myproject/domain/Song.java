package com.myproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "song")
@Data
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id" )
    private Long songId;

    @Column(name = "title")
    private String titel;

    @Column(name = "size")
    private Long size;

    @Column(name = "track")
    private Integer track;

    @Column(name = "genre")
    private String genre;

    @Column(name = "lyrics")
    private String lyrics;

    @Column(name = "path")
    private String path;

    @Column(name = "type")
    private String type;

    @Column(name = "create_at")
    private Long createAt;

    @Column(name = "update_at")
    private Long updateAt;

    @OneToOne
    @JsonIgnoreProperties(value = {"artist", "albums", "playlist", "user"}, allowSetters = true)
    @JoinColumn(name = "song_image", unique = true)
    private Image image;

    @ManyToOne
    @JsonIgnoreProperties(value = {"image", "albums"},allowSetters = true)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JsonIgnoreProperties(value = {"image", "artist"}, allowGetters = true)
    @JoinColumn(name = "album_id")
    private Album album;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"user"}, allowSetters = true)
    private Set<Interaction> interactions;

    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = {"image", "user"}, allowSetters = true)
    @JoinTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Song> playlistSongs;

}

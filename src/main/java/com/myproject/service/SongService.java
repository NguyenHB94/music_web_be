package com.myproject.service;

import com.myproject.controller.vm.UploadSongVM;
import com.myproject.domain.Song;
import com.myproject.repository.SongRepository;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }



}

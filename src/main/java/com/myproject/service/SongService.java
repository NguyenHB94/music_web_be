package com.myproject.service;

import com.myproject.controller.vm.UploadSongVM;
import com.myproject.domain.Song;
import com.myproject.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song uploadSong(UploadSongVM uploadSongVM) throws IOException {
        String absolutePath = "/home/lcn/Desktop/Spring-Boot/final_project/SongData/";
        long unixTime = System.currentTimeMillis() / 1000L;
        String fileSavePath = absolutePath + String.valueOf(unixTime) + uploadSongVM.getSongMedia().getOriginalFilename();
        File savedFile =new File(fileSavePath);
        uploadSongVM.getSongMedia().transferTo(savedFile);

        Song newSong = new Song();
        newSong.setTitel(uploadSongVM.getTitle());
        newSong.setGenre(uploadSongVM.getGenre());
        newSong.setPath(fileSavePath);
        newSong.setType(uploadSongVM.getSongMedia().getContentType());
        newSong.setSize(uploadSongVM.getSongMedia().getSize());

        return this.songRepository.save(newSong);
    }


}

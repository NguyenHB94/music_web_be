package com.myproject.controller;

import com.myproject.controller.vm.UploadSongVM;
import com.myproject.service.SongService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;

@RestController
@RequestMapping("/api/song")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping(path = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadSong( UploadSongVM uploadSongVM) {
        try {
            var ret = this.songService.uploadSong(uploadSongVM);
            return ResponseEntity.ok("Upload success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Upload Fail");
        }
    }
}

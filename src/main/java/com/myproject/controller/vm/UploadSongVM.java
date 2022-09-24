package com.myproject.controller.vm;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class UploadSongVM {
    private String title;
    private String genre;
    private MultipartFile songMedia;
}

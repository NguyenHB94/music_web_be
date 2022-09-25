package com.myproject.controller.vm;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadSongVM {
    private String title;
    private String genre;
    private MultipartFile songMedia;
}

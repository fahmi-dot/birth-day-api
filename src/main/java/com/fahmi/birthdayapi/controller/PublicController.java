package com.fahmi.birthdayapi.controller;

import com.fahmi.birthdayapi.dto.ImageResponse;
import com.fahmi.birthdayapi.entity.Image;
import com.fahmi.birthdayapi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PublicController {

    private final ImageService imageService;

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(
            @RequestParam String caption,
            @RequestParam("file") MultipartFile file
    ) {
        imageService.uploadImage(caption, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/image")
    public ResponseEntity<?> getAllImage() {
        List<ImageResponse> response = imageService.getAllImages();
        return ResponseEntity.ok(response);
    }
}

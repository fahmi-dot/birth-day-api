package com.fahmi.birthdayapi.controller;

import com.fahmi.birthdayapi.dto.ImageResponse;
import com.fahmi.birthdayapi.dto.SpeechResponse;
import com.fahmi.birthdayapi.service.ImageService;
import com.fahmi.birthdayapi.service.SpeechService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PublicController {

    private final ImageService imageService;
    private final SpeechService speechService;

    @PostMapping("/images")
    public ResponseEntity<?> uploadImage(
            @RequestParam String createdBy,
            @RequestParam String caption,
            @RequestParam("file") MultipartFile file
    ) {
        imageService.uploadImage(createdBy, caption, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/images")
    public ResponseEntity<?> getAllImages() {
        List<ImageResponse> response = imageService.getAllImages();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/speeches")
    public ResponseEntity<?> uploadSpeech(@RequestBody SpeechResponse request) {
        speechService.uploadSpeech(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/speeches")
    public ResponseEntity<?> getAllSpeeches() {
        List<SpeechResponse> response = speechService.getAllSpeech();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/speeches/{id}")
    public ResponseEntity<?> deleteSpeech(@PathVariable String id) {
        speechService.deleteSpeech(id);
        return ResponseEntity.ok().build();
    }
}

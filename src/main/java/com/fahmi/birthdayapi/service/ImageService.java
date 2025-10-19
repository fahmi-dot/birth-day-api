package com.fahmi.birthdayapi.service;

import com.fahmi.birthdayapi.dto.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    void uploadImage(String createdBy, String caption, MultipartFile file);

    List<ImageResponse> getAllImages();
}

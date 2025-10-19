package com.fahmi.birthdayapi.service.impl;

import com.cloudinary.Cloudinary;
import com.fahmi.birthdayapi.dto.ImageResponse;
import com.fahmi.birthdayapi.entity.Image;
import com.fahmi.birthdayapi.repository.ImageRepository;
import com.fahmi.birthdayapi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final Cloudinary cloudinary;
    private final ImageRepository imageRepository;

    @Override
    public void uploadImage(String createdBy, String caption, MultipartFile file) {
        String fileName = file.getOriginalFilename();
        if (fileName == null || (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png"))) {
            throw new RuntimeException("Only JPG/PNG files are allowed.");
        }
        String imageUrl = uploadFile(file, "birth-day");
        Image image = Image.builder()
                .imageUrl(imageUrl)
                .caption(caption)
                .createdBy(createdBy)
                .build();
        imageRepository.save(image);
    }

    @Override
    public List<ImageResponse> getAllImages() {
        List<Image> images = imageRepository.findAll();
        return images.stream().map((i) -> ImageResponse.builder()
                .id(i.getId())
                .imageUrl(i.getImageUrl())
                .caption(i.getCaption())
                .createdBy(i.getCreatedBy())
                .build()).toList();
    }

    public String uploadFile(MultipartFile file, String folder) {
        try {
            Map<?, ?> result = cloudinary.uploader().upload(file.getBytes(), Map.of("folder", folder));
            return (String) result.get("secure_url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

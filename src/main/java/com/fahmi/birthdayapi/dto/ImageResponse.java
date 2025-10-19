package com.fahmi.birthdayapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageResponse {
    private String id;
    private String imageUrl;
    private String caption;
    private String createdBy;
}

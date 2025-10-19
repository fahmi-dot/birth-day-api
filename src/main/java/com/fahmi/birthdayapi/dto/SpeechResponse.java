package com.fahmi.birthdayapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpeechResponse {
    private String id;
    private String header;
    private String from;
    private String content;
}

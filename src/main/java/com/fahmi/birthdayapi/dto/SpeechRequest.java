package com.fahmi.birthdayapi.dto;

import lombok.Data;

@Data
public class SpeechRequest {
    private String header;
    private String from;
    private String content;
}

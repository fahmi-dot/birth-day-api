package com.fahmi.birthdayapi.service;

import com.fahmi.birthdayapi.dto.SpeechResponse;

import java.util.List;

public interface SpeechService {
    void uploadSpeech(SpeechResponse request);

    List<SpeechResponse> getAllSpeech();
}

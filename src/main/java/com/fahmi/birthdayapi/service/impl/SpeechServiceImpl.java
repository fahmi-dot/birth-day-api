package com.fahmi.birthdayapi.service.impl;

import com.fahmi.birthdayapi.dto.SpeechResponse;
import com.fahmi.birthdayapi.entity.Speech;
import com.fahmi.birthdayapi.repository.SpeechRepository;
import com.fahmi.birthdayapi.service.SpeechService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpeechServiceImpl implements SpeechService {

    private final SpeechRepository speechRepository;

    @Override
    public void uploadSpeech(SpeechResponse request) {
        Speech speech = Speech.builder()
                .header(request.getHeader())
                .itsFrom(request.getFrom())
                .content(request.getContent())
                .build();
        speechRepository.save(speech);
    }

    @Override
    public List<SpeechResponse> getAllSpeech() {
       List<Speech> speeches = speechRepository.findAll();
       return speeches.stream().map((s) -> SpeechResponse.builder()
               .id(s.getId())
               .header(s.getHeader())
               .from(s.getItsFrom())
               .content(s.getContent())
               .build()).toList();
    }
}

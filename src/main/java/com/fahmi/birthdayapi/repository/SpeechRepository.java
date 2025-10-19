package com.fahmi.birthdayapi.repository;

import com.fahmi.birthdayapi.entity.Speech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeechRepository extends JpaRepository<Speech, String> {
}

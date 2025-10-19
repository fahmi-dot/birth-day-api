package com.fahmi.birthdayapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "speech")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Speech {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String header;

    @Column(name = "its_from")
    private String itsFrom;

    @Column(columnDefinition = "text")
    private String content;
}

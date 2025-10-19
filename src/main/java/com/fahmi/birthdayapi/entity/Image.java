package com.fahmi.birthdayapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "image_url")
    private String imageUrl;

    private String caption;

    @Column(name = "created_by")
    private String createdBy;
}

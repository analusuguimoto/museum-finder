package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Museum creation dto.
 */
public record MuseumCreationDto(
        Long id,
        String name,
        String description,
        String address,
        String collectionType,
        String subject,
        String url,
        Coordinate coordinate
){}

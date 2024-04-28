package com.betrybe.museumfinder.dto;

/**
 * Museum creation dto.
 */
import com.betrybe.museumfinder.model.Coordinate;

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

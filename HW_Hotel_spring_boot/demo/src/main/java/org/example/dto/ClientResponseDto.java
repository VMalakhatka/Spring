package org.example.dto;

import java.time.LocalDate;

public record ClientResponseDto(String firstName, String lastName, LocalDate birthday) {
}

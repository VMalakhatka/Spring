package org.example.dto;

import java.time.LocalDate;
import java.util.Date;

public record ClientRequestDto(String firstName, String lastName, LocalDate birthday) {
}

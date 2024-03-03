package org.example.dto;

import java.time.LocalDate;
import java.util.Date;

public record BookingResponseDto(LocalDate date, String wishes, ClientResponseDto client) {
}

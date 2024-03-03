package org.example.dto;

import java.time.LocalDate;

public record BookingRequestDto(LocalDate start, LocalDate end, int roomNumber, String wishes, ClientRequestDto client) {
}

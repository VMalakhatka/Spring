package org.example.dto;

import java.util.Set;

public record RoomResponseDto(int number, String comment, Set<BookingResponseDto> bookingResponseDtos) {
}

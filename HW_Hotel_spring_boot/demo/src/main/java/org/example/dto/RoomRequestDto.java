package org.example.dto;

import java.time.LocalDate;
import java.util.Set;

public record RoomRequestDto(int number, String comment, LocalDate start, LocalDate end , int client_id) {
}

package org.example.dto;

import java.time.LocalDate;

public record User(Long id, String firstName, String lastName, LocalDate birthDate, String email) {
    private static long count = 0;

    public User(User original, String firstName, String lastName, int age, boolean consent) {
        this(count++, original.firstName, original.lastName, original.birthDate, original.email);
    }
}

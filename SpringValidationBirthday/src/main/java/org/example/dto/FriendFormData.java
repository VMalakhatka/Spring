package org.example.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public final class FriendFormData {

    @NotBlank
    @Size(min = 1, max = 100, message = "Name length must be between 1 and 100")
    private String firstName;
    @NotBlank
    @Size(min = 1, max = 100, message = "Name length must be between 1 and 100")
    private String lastName;
    @PastOrPresent( message = "The date must be in the past")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate birthday;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}

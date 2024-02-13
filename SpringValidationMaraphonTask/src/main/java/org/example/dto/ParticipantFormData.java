package org.example.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public final class ParticipantFormData {

    @NotBlank
    @Size(min = 1, max = 100, message = "Name length must be between 1 and 100")
    private String firstName;
    @NotBlank
    @Size(min = 1, max = 100, message = "Name length must be between 1 and 100")
    private String lastName;

    @Min(value = 18, message = "You must be adult (18+)")
    private int age;
    @AssertTrue(message = "Tick i agree")
    private boolean isAgree;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAgree() {
        return isAgree;
    }

    public void setAgree(boolean agree) {
        this.isAgree = agree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantFormData that = (ParticipantFormData) o;

        if (age != that.age) return false;
        if (isAgree != that.isAgree) return false;
        if (!firstName.equals(that.firstName)) return false;
        return lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        result = 31 * result + (isAgree ? 1 : 0);
        return result;
    }

    public ParticipantFormData() {

    }
}

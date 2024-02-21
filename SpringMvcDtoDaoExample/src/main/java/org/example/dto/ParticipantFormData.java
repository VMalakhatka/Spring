package org.example.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public final class ParticipantFormData {
    @NotBlank
    @Size(min =1, max=100, message = "Name length must be between 1 - 100 digits")
    private String firstName;
    @NotBlank
    @Size(min =1, max=100, message = "Surname length must be between 1 - 100 digits")
    private String lastName;
    @Min(value = 18, message = "You must be adult")
    private int age;
    @AssertTrue(message = "Tick I agree")
    private Boolean isAgree;

    public ParticipantFormData() { }

    public User toUser() {
        return new User(null, firstName, lastName, age, isAgree);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipantFormData that)) return false;

        if (getAge() != that.getAge()) return false;
        if (getIsAgree() != that.getIsAgree()) return false;
        if (!getFirstName().equals(that.getFirstName())) return false;
        return getLastName().equals(that.getLastName());
    }

    @Override
    public int hashCode() {
        int result = getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + (getIsAgree() ? 1 : 0);
        return result;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getIsAgree() {
        return isAgree;
    }

    public void setAgree(boolean agree) {
        this.isAgree = agree;
    }
}

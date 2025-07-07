package com.gamehub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import com.gamehub.validation.ValidPassword;
import com.gamehub.validation.ValidPasswordMatch;

@ValidPasswordMatch
public class UserDTO {

    @NotEmpty(message = "First name is required.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    private String lastName;

    @Email(message = "Enter a valid email.")
    @NotEmpty(message = "Email is required.")
    private String email;

    @NotEmpty(message = "Phone number is required.")
    private String phone;

    @NotEmpty(message = "Username is required.")
    private String username;

    @NotEmpty(message = "Password cannot be empty.")
    @ValidPassword(message = "Insufficient password strength.")
    private String password;

    @NotEmpty(message = "Confirm password cannot be empty.")
    private String confirmPassword;

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getConfirmPassword() { return confirmPassword; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }
}

package com.bethfrench.photographyportfolio.SignupForm;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignupForm {

    @NotNull
    @Email
    private String username;

    @NotNull
    @Size(min=6)
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    public String address;

    @NotNull
    public String phoneNumber;


    public SignupForm() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean passwordsMatch() {
        return confirmPassword.equals(password);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}


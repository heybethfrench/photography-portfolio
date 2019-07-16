package com.bethfrench.photographyportfolio.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Transient
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue
    public int id;

    @NotNull
    @Column(unique=true)
    @Email
    public String username;

    @NotNull
    public String address;

    @NotNull
    public String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<MyGrantAuthority> authorities;

    private String passwordHash;

    @NotNull
    private boolean accountNonExpired;

    @NotNull
    private boolean accountNonLocked;

    @NotNull
    private boolean credentialsNonExpired;

    @NotNull
    private boolean enabled;

    public User() {
        authorities = new HashSet<>();
    }

    public User(String username, Set<MyGrantAuthority> authorities, String password, String address, String phoneNumber) {
        this.username = username;
        this.authorities = authorities;
        this.setPassword(password);
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


    public void setPassword(String password) {
        setPasswordHash(passwordEncoder.encode(password));
    }

    public boolean checkPassword(String password) {
        return passwordEncoder.matches(password, getPasswordHash());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addAuthority(MyGrantAuthority authority) {
        authorities.add(authority);
    }

    public boolean removeAuthority(MyGrantAuthority authority) {
        return authorities.remove(authority);
    }

    public Set<MyGrantAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<MyGrantAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

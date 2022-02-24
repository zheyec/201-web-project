package com.colorly.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Username cannot be empty!")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Username contains special characters!")
    private String username;

    @NotEmpty(message = "Email cannot be empty!")
    @Email(message = "Email is invalid!")
    private String email;

    @JsonIgnore
    @NotEmpty(message = "Password cannot be empty!")
    @Size(min = 6, message = "Password has length less than 6!")
    private String password;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

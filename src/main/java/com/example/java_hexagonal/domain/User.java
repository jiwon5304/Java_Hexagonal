package com.example.java_hexagonal.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
public class User {

    private long id;
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {

    }

    public static User of(String name, String password) {
        return new User(name, password);
    }

}

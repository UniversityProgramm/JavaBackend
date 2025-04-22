package com.task19.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NonNull private String firstname;
    @NonNull private String surname;
    @NonNull private String lastname;

    @NonNull private String login;
    @NonNull private String password;

    public User(@NonNull String firstname, @NonNull String surname, @NonNull String lastname, @NonNull String login, @NonNull String password) {
        this.firstname = firstname;
        this.surname = surname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }
}

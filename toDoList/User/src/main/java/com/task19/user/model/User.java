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
    private Long id;

    @NonNull private String firstname;
    @NonNull private String surname;
    @NonNull private String lastname;

    @NonNull private String login;
    @NonNull private String password;
    @NonNull private String role;

    public User(@NonNull String firstname, @NonNull String surname, @NonNull String login, @NonNull String lastname, @NonNull String password, @NonNull String role) {
        this.firstname = firstname;
        this.surname = surname;
        this.login = login;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
    }
}

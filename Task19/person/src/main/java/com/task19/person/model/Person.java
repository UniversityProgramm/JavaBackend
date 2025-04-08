package com.task19.person.model;

import com.task19.location.model.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @NonNull private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @NonNull private Location location;

    public Person(@NonNull String name,@NonNull Location location) {
        this.name = name;
        this.location = location;
    }
}
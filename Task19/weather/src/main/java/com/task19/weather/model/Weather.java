package com.task19.weather.model;

import com.task19.location.model.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Weather {
    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private double temperature;
    @NonNull
    private double speedWind;
    @NonNull
    private double wetness;

    @ManyToOne(cascade = CascadeType.ALL)
    @NonNull private Location location;

    @NonNull
    private WeatherCondition condition;
}

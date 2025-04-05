package com.task19.weather.model;

import lombok.Getter;

@Getter
public enum WeatherCondition {
    SUNNY("Sunny"),
    FOGGY("Foggy"),
    CLOUDY("Cloudy"),
    PARTLY_CLOUDY("Partly Cloudy"),
    RAINY("Rainy"),
    SNOWY("Snowy"),
    WINDY("Windy"),
    THUNDERSTORM("Thunderstorm");

    private final String displayName;

    WeatherCondition(String displayName) {
        this.displayName = displayName;
    }
}
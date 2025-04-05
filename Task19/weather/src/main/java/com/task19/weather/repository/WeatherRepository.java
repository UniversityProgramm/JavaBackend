package com.task19.weather.repository;

import com.task19.weather.model.Weather;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Integer> {
    @Query("SELECT w FROM Weather w WHERE w.location.latitude = :lat AND w.location.longitude = :lon")
    Weather findByCoordinates(@Param("lat") double latitude, @Param("lon") double longitude);
}

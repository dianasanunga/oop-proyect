package com.ups.oop.repository;

import com.ups.oop.entity.Branch;
import com.ups.oop.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CityRepository  extends CrudRepository<City, Long> {
    Optional<City> findByIdCity(String idCity);
}

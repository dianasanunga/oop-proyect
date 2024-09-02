package com.ups.oop.repository;

import com.ups.oop.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository  extends CrudRepository<City, Long> {

}

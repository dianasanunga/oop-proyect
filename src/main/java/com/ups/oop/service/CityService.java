package com.ups.oop.service;

import com.ups.oop.dto.CityDTO;
import com.ups.oop.entity.City;
import com.ups.oop.repository.CityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {

        this.cityRepository = cityRepository;
    }

    private List<CityDTO> cityDTOList = new ArrayList<>();

    public ResponseEntity createCity(CityDTO cityDTO) {
        String cityId = cityDTO.getIdCity();
        Optional<City> cityOptional = cityRepository.findByIdCity(cityId);

        if (cityOptional.isPresent()) {
            String errorMessage = "City with id " + cityId + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            City city = new City();
            city.setIdCity(cityId);
            city.setName(cityDTO.getName());
            city.setDescription(cityDTO.getDescription());
            cityRepository.save(city);
            return ResponseEntity.status(HttpStatus.OK).body(city);
        }
    }

    public ResponseEntity getAllCity(){
        Iterable<City> cityIterable = cityRepository.findAll();
        List<CityDTO> citiesList = new ArrayList<>();

        for (City c : cityIterable) {
            CityDTO city = new CityDTO(c.getIdCity(),c.getName(),c.getDescription());
            citiesList.add(city);
        }
        if (citiesList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cities List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(citiesList);
    }

    public ResponseEntity getCityById(String cityId){
        Optional<City> cityOptional = cityRepository.findByIdCity(cityId);

        if(cityOptional.isPresent()){
            City c = cityOptional.get();
            CityDTO city = new CityDTO(c.getIdCity(),c.getName(),c.getDescription());

            return ResponseEntity.status(HttpStatus.OK).body(city);
        }else{
            String errorMessage = "City with id " + cityId + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateCity(CityDTO cityDTO){
        String idCity = cityDTO.getIdCity();
        Optional<City> cityOptional = cityRepository.findByIdCity(idCity);

        if(cityOptional.isPresent()){
            City city = cityOptional.get();
            city.setIdCity(idCity);
            city.setName(cityDTO.getName());
            city.setDescription(cityDTO.getDescription());
            cityRepository.save(city);
            return ResponseEntity.status(HttpStatus.OK).body(cityDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("City with id " + idCity + " doesn't exits");
        }
    }

    public ResponseEntity deleteCityById(String id){
        String message = "City with id " + id;
        Optional<City> cityOptional = cityRepository.findByIdCity(id);

        if(cityOptional.isPresent()){
            cityRepository.delete((cityOptional.get()));
            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
        }
    }
}

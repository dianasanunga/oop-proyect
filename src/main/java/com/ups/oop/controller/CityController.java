package com.ups.oop.controller;

import com.ups.oop.dto.CityDTO;
import com.ups.oop.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityDTO cityDTO){
        return this.cityService.createCity(cityDTO);
    }

    @GetMapping("/get-all-city")
    public ResponseEntity getAllCity(){
        return this.cityService.getAllCity();
    }

    @GetMapping("/get-city")
    public ResponseEntity getCityById(@RequestParam String id){
        return this.cityService.getCityById(id);
    }

    @PutMapping("/update-city")
    public ResponseEntity updateCity(@RequestBody CityDTO cityDTO){
        return this.cityService.updateCity(cityDTO);
    }

    @DeleteMapping("/remove-city")
    public ResponseEntity deleteCityById(@RequestParam String id){
        return this.cityService.deleteCityById(id);
    }
}

package com.ups.oop.controller;

import com.ups.oop.dto.BuyerDTO;
import com.ups.oop.service.BuyerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyerController {
    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping("/buyer")
    public ResponseEntity createBuyer(@RequestBody BuyerDTO buyerDTO){
        return this.buyerService.createBuyer(buyerDTO);
    }

    @GetMapping("/get-all-buyers")
    public ResponseEntity getAllBuyer(){
        return this.buyerService.getAllBuyer();
    }

    @GetMapping("/get-buyer")
    public ResponseEntity getBuyerById(@RequestParam String id){
        return this.buyerService.getBuyerById(id);
    }

    @PutMapping("/update-buyer")
    public ResponseEntity updateBuyer(@RequestBody BuyerDTO buyerDTO){
        return this.buyerService.updateBuyer(buyerDTO);
    }

    @DeleteMapping("/remove-buyer")
    public ResponseEntity deleteBuyerById(@RequestParam String id){
        return this.buyerService.deleteBuyerById(id);
    }
}

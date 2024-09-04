package com.ups.oop.service;

import com.ups.oop.dto.BuyerDTO;
import com.ups.oop.entity.Buyer;
import com.ups.oop.repository.BuyerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {
    private final BuyerRepository buyerRepository;

    private List<BuyerDTO> buyerDTOList = new ArrayList<>();

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public ResponseEntity createBuyer(BuyerDTO buyerDTO) {
        String buyerId = buyerDTO.getBuyerId();
        Optional<Buyer> buyerOptional = buyerRepository.findByBuyerId(buyerId);
        if (buyerOptional.isPresent()) {
            String errorMessage = "buyer with id " + buyerDTO.getBuyerId() + " already exists";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {

            Buyer buyerRecord = new Buyer();
            buyerRecord.setBuyerId(buyerId);
            buyerRecord.setName(buyerDTO.getName());
            buyerRecord.setLastname(buyerDTO.getLastname());
            buyerRecord.setAge(Integer.valueOf(buyerDTO.getAge()));
            buyerRepository.save(buyerRecord);
            return ResponseEntity.status(HttpStatus.OK).body(buyerDTO);

        }
    }

    public ResponseEntity getAllBuyer() {
        Iterable<Buyer> buyerIterable = buyerRepository.findAll();
        List<BuyerDTO> buyerList = new ArrayList<>();

        for (Buyer b : buyerIterable) {
            BuyerDTO buyer = new BuyerDTO(b.getBuyerId(), b.getRegistrationDate().toString(), b.getName(), b.getLastname(),
                    b.getAge().toString(), b.getCity().getName(), b.getAddress(), b.getPhoneNumber(), b.getEmail());
            buyerList.add(buyer);


        }
        if (buyerList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Buyer List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(buyerList);
    }

    public ResponseEntity getBuyerById(String buyerId) {
        Optional<Buyer> buyerOptional = buyerRepository.findByBuyerId(buyerId);

        if (buyerOptional.isPresent()) {
            Buyer b = buyerOptional.get();
            BuyerDTO buyer = new BuyerDTO(b.getBuyerId(), b.getRegistrationDate().toString(), b.getName(), b.getLastname(),
                    b.getAge().toString(), b.getCity().getName(), b.getAddress(), b.getPhoneNumber(), b.getEmail());

            return ResponseEntity.status(HttpStatus.OK).body(buyer);
        } else {
            String errorMessage = "buyer with id " + buyerId + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }

    }

    public ResponseEntity updateBuyer(BuyerDTO buyerDTO){
        String buyerId = buyerDTO.getBuyerId();
        Optional<Buyer> buyerOptional = buyerRepository.findByBuyerId(buyerId);
        if (buyerOptional.isPresent()){
            Buyer buyer = buyerOptional.get();
            buyer.setBuyerId(buyerId);
            buyer.setName(buyerDTO.getName());
            buyer.setLastname(buyerDTO.getLastname());
            buyer.setAge(Integer.valueOf(buyerDTO.getAge()));
            buyerRepository.save(buyer);
            return ResponseEntity.status(HttpStatus.OK).body(buyerDTO);
        }else{
            String errorMessage = "buyer with id " + buyerDTO.getBuyerId() + " already exists";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
    public ResponseEntity deleteBuyerById(String id){
        String message = "Buyer with id " + id;
        Optional<Buyer> buyerOptional = buyerRepository.findByBuyerId(id);
        if (buyerOptional.isPresent()) {
            buyerRepository.delete((buyerOptional.get()));
            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");}

    }
}
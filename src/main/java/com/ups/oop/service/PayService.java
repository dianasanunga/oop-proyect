package com.ups.oop.service;


import com.ups.oop.dto.PayDTO;
import com.ups.oop.entity.Pay;
import com.ups.oop.repository.PayRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PayService {
    public PayService(PayRepository payRepository) {
        this.payRepository = payRepository;
    }

    private List<PayDTO> payDTOList = new ArrayList<>();

    public ResponseEntity createPay(PayDTO payDTO) {
        String idPay = payDTO.getidPay();
        Optional<Pay> payOptional = payRepository.findByIdPay(idPay);

        if (productOptional.isPresent()) {
            String errorMessage = "Pay with id " + idPay + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            Pay pay = new Pay();
            pay.setIdPay(idPay);
            pay.setName(payDTO.getName());
            pay.setDescription(payDTO.getDescription());
            return ResponseEntity.status(HttpStatus.OK).body(pay);
        }
    }

    public ResponseEntity getAllPays() {
        Iterable<Pay> payIterable = payRepository.findAll();
        List<PayDTO> paysList = new ArrayList<>();

        for (Pay p : payIterable) {
            PayDTO pay = new PayDTO(p.getIdPay(), p.getName(),
                    p.getDescription());
            paysList.add(pay);
        }
        if (paysList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pay List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(paysList);
    }

    public ResponseEntity getPaysById(String idPay) {
        Optional<Pay> payOptional = payRepository.findByIdPay(idPay);

        if (payOptional.isPresent()) {
            Pay payFound = payOptional.get();
            PayDTO pay = new PayDTO();
            pay.setIdPay(idPay);
            pay.setName(payFound.getName());
            pay.setDescription(payFound.getDescription());
            return ResponseEntity.status(HttpStatus.OK).body(pay);

        } else {
            String errorMessage = "Pay with id " + idPay + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updatePay(PayDTO payDTO){
        String idPay = payDTO.getIdPay();
        Optional<Pay> payOptional = payRepository.findByIdPay(idPay);
        if (payOptional.isPresent()) {
            Pay pay = new Pay();
            pay.setIdBranch(idProduct);
            pay.setName(productDTO.getName());
            pay.setDescription(payDTO.getDescription());
            return ResponseEntity.status(HttpStatus.OK).body(pay);
        } else {
            String errorMessage = "Pay with id " + idPay + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity deletePayById(String id){
        String message = "Product with id " + id;
        Optional<Pay> payOptional = payRepository.findByIdPay(id);
        if (payOptional.isPresent()) {
            payRepository.delete((payOptional.get()));
            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");}

    }

}

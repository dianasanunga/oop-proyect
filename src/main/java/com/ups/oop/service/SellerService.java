package com.ups.oop.service;

import com.ups.oop.dto.SellerDTO;
import com.ups.oop.entity.Seller;
import com.ups.oop.repository.SellerRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SellerService {
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;

    }

    private List<SellerDTO> sellerList = new ArrayList<>();

    public ResponseEntity createSeller(SellerDTO sellerDTO) {
        String sellerId = sellerDTO.getIdSeller();
        Optional<Seller> sellerOptional = sellerRepository.findByIdSeller(sellerId);

        if (sellerOptional.isPresent()) {
            String errorMessage = "Seller with id " + sellerId + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {

                Seller seller = new Seller();
                seller.setIdSeller(sellerId);
                seller.setName(sellerDTO.getName());
                seller.setLastname(sellerDTO.getLastname());
                seller.setAge(Integer.valueOf(sellerDTO.getAge()));
                seller.setAddress(sellerDTO.getAddress());
                seller.setPhoneNumber(sellerDTO.getPhoneNumber());
                seller.setEmail(sellerDTO.getEmail());
                return ResponseEntity.status(HttpStatus.OK).body(seller);

        }
    }

    public ResponseEntity getAllSellers() {
        Iterable<Seller> sellerIterable = sellerRepository.findAll();
        List<SellerDTO> sellerList = new ArrayList<>();

        for (Seller s : sellerIterable) {
            SellerDTO seller = new SellerDTO(s.getIdSeller(),
     s.getName(), s.getLastname(), s.getAge().toString(),s.getCity().getName(),s.getAddress(),s.getPhoneNumber(),s.getEmail());
            sellerList.add(seller);
        }
        if (sellerList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sellers List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(sellerList);
    }

    public ResponseEntity getSellerById(String sellerId){
        Optional<Seller> sellerOptional = sellerRepository.findByIdSeller(sellerId);

        if(sellerOptional.isPresent()){
            Seller s = sellerOptional.get();
            SellerDTO seller = new SellerDTO(s.getIdSeller(),s.getName(), s.getLastname(),
                    s.getAge().toString(),s.getCity().getName(),s.getAddress(),s.getPhoneNumber(),s.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(seller);
        }else{
            String errorMessage = "Sellers with id " + sellerId + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateSeller(SellerDTO sellerDTO) {
        String sellerId = sellerDTO.getIdSeller();
        Optional<Seller> sellerOptional = sellerRepository.findByIdSeller(sellerId);

        if (sellerOptional.isPresent()) {
                Seller seller = new Seller();
                seller.setIdSeller(sellerId);
                seller.setName(sellerDTO.getName());
                seller.setLastname(sellerDTO.getLastname());
                seller.setAge(Integer.valueOf(sellerDTO.getAge()));
                seller.setAddress(sellerDTO.getAddress());
                seller.setPhoneNumber(sellerDTO.getPhoneNumber());
                seller.setEmail(sellerDTO.getEmail());
                return ResponseEntity.status(HttpStatus.OK).body(seller);
        } else {
            String errorMessage = "Seller with id " + sellerId + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    public ResponseEntity deleteSeller(String id){
        String message = "Seller with id " + id;
        Optional<Seller> sellerOptional = sellerRepository.findByIdSeller(id);

        if(sellerOptional.isPresent()){
            sellerRepository.delete((sellerOptional.get()));
            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
        }
    }
}

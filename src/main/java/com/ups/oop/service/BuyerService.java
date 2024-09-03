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
            if (buyerDTO.getName().contains(" ")) {
                Buyer buyerRecord = new Buyer();
                buyerRecord.setBuyerId(buyerId);
                String[] nameStrings = buyerDTO.getName().split(" ");
                String name = nameStrings[0];
                String lastname = nameStrings[1];
                buyerRecord.setName(name);
                buyerRecord.setLastname(lastname);
                buyerRecord.setAge(Integer.valueOf(buyerDTO.getAge()));
                buyerRepository.save(buyerRecord);
                return ResponseEntity.status(HttpStatus.OK).body(buyerDTO);

            } else {

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("buyer name must contain two strings separated by a whitespace");
            }

        }
    }
        public List<BuyerDTO>getBuyer() {
            Iterable<Buyer> buyerIterable = buyerRepository.findAll();
            List<BuyerDTO> buyerList = new ArrayList<>();

            for (Buyer b : buyerIterable) {
                BuyerDTO buyer = new BuyerDTO(b.getBuyerId(), b.getRegistrationDate().toString(), b.getName(), b.getLastname(),
                        b.getAge().toString(), b.getCity().getName(), b.getAddress(), b.getPhoneNumber(), b.getEmail());
                buyerList.add(buyer);

            }

            return buyerList;

        }
    public ResponseEntity getAllBuyer(){
        Iterable<Buyer>buyerIterable = buyerRepository.findAll();
        List<BuyerDTO> buyerList = new ArrayList<>();

        for(Buyer b: buyerIterable) {
            BuyerDTO buyer = new BuyerDTO(b.getBuyerId(), b.getRegistrationDate().toString(), b.getName(), b.getLastname(),
                    b.getAge().toString(), b.getCity().getName(), b.getAddress(), b.getPhoneNumber(), b.getEmail());
            buyerList.add(buyer);


        }
        if(buyerList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Buyer List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(buyerList);
    }

    public ResponseEntity getBuyerById(String personId){
        Optional<Person> personOptional = personRepository.findByPersonId(personId);

        if(personOptional.isPresent()){
            Person personFound = personOptional.get();
            PersonDTO person = new PersonDTO(personFound.getPersonId(),
                    personFound.getName() + "-" + personFound.getLastname(),
                    personFound.getAge());
            return ResponseEntity.status(HttpStatus.OK).body(person);
        } else {

    }

}

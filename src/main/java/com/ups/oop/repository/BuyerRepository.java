package com.ups.oop.repository;

import com.ups.oop.entity.Buyer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BuyerRepository extends CrudRepository<Buyer, Long> {
    Optional<Buyer> findByBuyerId(String buyerId);
}

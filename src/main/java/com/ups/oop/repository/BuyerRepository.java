package com.ups.oop.repository;

import com.ups.oop.entity.Buyer;
import org.springframework.data.repository.CrudRepository;

public interface BuyerRepository extends CrudRepository<Buyer, Long> {
}

package com.ups.oop.repository;

import com.ups.oop.entity.Seller;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SellerRepository extends CrudRepository<Seller, Long> {
    Optional<Seller> findByIdSeller(String idSeller);

}

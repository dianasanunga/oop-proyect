package com.ups.oop.repository;

import com.ups.oop.entity.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Long> {
}

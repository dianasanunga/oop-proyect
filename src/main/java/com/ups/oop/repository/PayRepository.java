package com.ups.oop.repository;

import com.ups.oop.entity.Pay;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PayRepository  extends CrudRepository<Pay, Long> {
    Optional<Pay> findByIdPay(String idPay);

}

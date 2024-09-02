package com.ups.oop.repository;

import com.ups.oop.entity.Pay;
import org.springframework.data.repository.CrudRepository;

public interface PayRepository  extends CrudRepository<Pay, Long> {
}

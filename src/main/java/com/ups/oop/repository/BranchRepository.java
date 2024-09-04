package com.ups.oop.repository;

import com.ups.oop.entity.Branch;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BranchRepository extends CrudRepository<Branch, Long> {
    Optional<Branch> findByIdBranch(String idBranch);
}

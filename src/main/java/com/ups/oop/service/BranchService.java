package com.ups.oop.service;

import com.ups.oop.dto.BranchDTO;
import com.ups.oop.entity.Branch;
import com.ups.oop.repository.BranchRepository;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    private List<BranchDTO> branchDTOList = new ArrayList<>();

    public ResponseEntity createBranch(BranchDTO branchDTO) {
        String idBranch = branchDTO.getIdBranch();
        Optional<Branch> branchOptional = branchRepository.findByIdBranch(idBranch);

        if (branchOptional.isPresent()) {
            String errorMessage = "Branch with id " + idBranch + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            Branch branch = new Branch();
            branch.setIdBranch(idBranch);
            branch.setName(branchDTO.getName());
            branch.setAddress(branchDTO.getAddress());
            branch.setEmployeeNumber(branchDTO.getEmployeeNumber());
            branch.setPhoneNumber(branchDTO.getPhoneNumber());
            return ResponseEntity.status(HttpStatus.OK).body(branch);
        }
    }

    public ResponseEntity getAllBranch() {
        Iterable<Branch> branchIterable = branchRepository.findAll();
        List<BranchDTO> branchesList = new ArrayList<>();

        for (Branch b : branchIterable) {
            BranchDTO branch = new BranchDTO(b.getIdBranch(), b.getName(),
                    b.getAddress(), b.getEmployeeNumber(), b.getPhoneNumber());
            branchesList.add(branch);
        }
        if (branchesList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(branchesList);
    }

    public ResponseEntity getBranchById(String idBranch) {
        Optional<Branch> branchOptional = branchRepository.findByIdBranch(idBranch);

        if (branchOptional.isPresent()) {
            Branch branchFound = branchOptional.get();
            BranchDTO branch = new BranchDTO();
            branch.setIdBranch(idBranch);
            branch.setName(branchFound.getName());
            branch.setAddress(branchFound.getAddress());
            branch.setEmployeeNumber(branchFound.getEmployeeNumber());
            branch.setPhoneNumber(branchFound.getPhoneNumber());
            return ResponseEntity.status(HttpStatus.OK).body(branch);

        } else {
            String errorMessage = "Branch with id " + idBranch + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateBranch(BranchDTO branchDTO){
        String idBranch = branchDTO.getIdBranch();
        Optional<Branch> branchOptional = branchRepository.findByIdBranch(idBranch);
        if (branchOptional.isPresent()) {
            Branch branch = new Branch();
            branch.setIdBranch(idBranch);
            branch.setName(branchDTO.getName());
            branch.setAddress(branchDTO.getAddress());
            branch.setEmployeeNumber(branchDTO.getEmployeeNumber());
            branch.setPhoneNumber(branchDTO.getPhoneNumber());
            return ResponseEntity.status(HttpStatus.OK).body(branch);
        } else {
            String errorMessage = "Branch with id " + idBranch + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity deleteBranchById(String id){
        String message = "Branch with id " + id;
        Optional<Branch> branchOptional = branchRepository.findByIdBranch(id);
        if (branchOptional.isPresent()) {
            branchRepository.delete((branchOptional.get()));
            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");}

    }

        }







package com.ups.oop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BranchDTO {
    private String IdBranch;
    private String name;
    private String address;
    private String employeeNumber;
    private String phoneNumber;
}

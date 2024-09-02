package com.ups.oop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class SellerDTO {
    private String idSeller;
    private String name;
    private String lastname;
    private String age;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;

}

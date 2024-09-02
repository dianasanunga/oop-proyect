package com.ups.oop.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String buyerId;
    private Date registrationDate;
    private String name;
    private String lastname;
    private Integer age;
    private String address;
    @ManyToOne
    @JoinColumn(name = "city", nullable = true)
    private City city;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "buyer")
    private List<Invoice> invoices = new ArrayList<>();

}

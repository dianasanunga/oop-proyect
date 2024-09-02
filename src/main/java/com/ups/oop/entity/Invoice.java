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
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serial;
    private String invoiceDate;
    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = true)
    private Buyer buyer;
    private double subtotal;
    private double tax;
    private double total;

    @ManyToOne
    @JoinColumn(name= "seller_id", nullable = true)
    private Seller seller;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> detailList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name= "pay_id", nullable = true)
    private Pay pay;

    @ManyToOne
    @JoinColumn(name= "branch_id", nullable = true)
    private Branch branch;

}

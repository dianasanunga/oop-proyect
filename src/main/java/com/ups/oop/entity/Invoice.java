package com.ups.oop.entity;

import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "buyer_id", nullable = true)
    private Buyer buyer;
    private Date loanDate;
    private Integer days;
    @ManyToOne
    @JoinColumn(name= "seller_id", nullable = true)
    private Seller seller;
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> detailList = new ArrayList<>();

}

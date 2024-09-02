package com.ups.oop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String idInvoiceDetail;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;
    private String unitPrice;
    private String quantity;
    private String total;

    @ManyToOne
    @JoinColumn(name = "invoice_detail", nullable = true)
    private Invoice invoice;


}

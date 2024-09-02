package com.ups.oop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class InvoiceDetailDTO {
    private String idInvoiceDetail;
    private String idInvoice;
    private String product;
    private String unitPrice;
    private String quantity;
    private String total;
}

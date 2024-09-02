package com.ups.oop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class InvoiceDTO {
    private String serial;
    private String invoiceDate;
    private String branch;
    private String buyer;
    private String subtotal;
    private String tax;
    private String total;
    private String seller;
    private String pay;

}

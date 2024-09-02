package com.ups.oop.controller;

import com.ups.oop.dto.InvoiceDetailDTO;
import com.ups.oop.entity.Invoice;
import com.ups.oop.service.InvoiceDetailService;
import com.ups.oop.service.InvoiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
    private final InvoiceDetailService invoiceDetailService;
    private final InvoiceService invoiceService;

    public TemplateController(InvoiceDetailService invoiceDetailService, InvoiceService invoiceService) {
        this.invoiceDetailService = invoiceDetailService;
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoice-detail")
    public String getInvoiceDetail(Model model) {
        model.addAttribute("invoiceDetail", invoiceDetailService.getInvoiceDetail());
        return "invoicedetail/list";
    }

    @GetMapping("/invoice")
    public String getInvoice(Model model){
        model.addAttribute("invoice", invoiceService.getInvoice());
        return "invoice/list";
    }

}

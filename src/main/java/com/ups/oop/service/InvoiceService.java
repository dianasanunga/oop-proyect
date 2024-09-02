package com.ups.oop.service;

import com.ups.oop.dto.InvoiceDTO;

import com.ups.oop.entity.Invoice;
import com.ups.oop.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    private  final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceDTO> getInvoice(){
        Iterable<Invoice> invoiceIterable = invoiceRepository.findAll();
        List<InvoiceDTO>invoiceDTOList = new ArrayList<>();

        for(Invoice id: invoiceIterable){
            InvoiceDTO invoiceDTO = new InvoiceDTO(id.getSerial(), id.getInvoiceDate(),
                    id.getBranch().getName(), id.getBuyer().getName() + " " + id.getBuyer().getLastname(),
                    String.valueOf(id.getSubtotal()),String.valueOf(id.getTax()), String.valueOf(id.getTotal()),
                    id.getSeller().getName()+ " " + id.getSeller().getLastname(), id.getPay().getName() );
            invoiceDTOList.add(invoiceDTO);
        }
        return invoiceDTOList;
    }


}

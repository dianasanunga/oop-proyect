package com.ups.oop.service;

import com.ups.oop.dto.InvoiceDetailDTO;
import com.ups.oop.entity.InvoiceDetail;
import com.ups.oop.repository.InvoiceDetailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class InvoiceDetailService {
    private  final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailService(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    public List<InvoiceDetailDTO>getInvoiceDetail(){
        Iterable<InvoiceDetail> invoiceDetailIterable = invoiceDetailRepository.findAll();
        List<InvoiceDetailDTO>invoiceDetailDTOList = new ArrayList<>();

        for(InvoiceDetail id: invoiceDetailIterable){
            InvoiceDetailDTO invoiceDetailDTO = new InvoiceDetailDTO(id.getIdInvoiceDetail(), id.getInvoice().getSerial(),
                    id.getProduct().getName(), id.getUnitPrice(),id.getQuantity(), id.getTotal() );
            invoiceDetailDTOList.add(invoiceDetailDTO);
        }
        return invoiceDetailDTOList;
    }


}

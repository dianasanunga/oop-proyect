package com.ups.oop.controller;

import com.ups.oop.dto.PayDTO;
import com.ups.oop.dto.SellerDTO;
import com.ups.oop.service.PayService;
import com.ups.oop.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
        private final PayService payService;
        public PayController(PayService payService) {
            this.payService = payService;
        }

        @GetMapping("/get-all-pay")
        public ResponseEntity getAllPays() {
            return this.payService.getAllPays();
        }

        @GetMapping("/get-pay")
        public ResponseEntity getPaysById(@RequestParam String id) {
            return this.payService.getPaysById(id);
        }

        @PostMapping("/pay")
        public ResponseEntity createPay(@RequestBody PayDTO PayDTO) {
            return this.payService.createPay(PayDTO);
        }

        @PutMapping("/update-pay")
        public ResponseEntity updatePay(@RequestBody PayDTO PayDTO) {
            return this.payService.updatePay(PayDTO);
        }

        @DeleteMapping("/remove-pay")
        public ResponseEntity deletePayById(@RequestParam String id) {
            return this.payService.deletePayById(id);
        }


    }

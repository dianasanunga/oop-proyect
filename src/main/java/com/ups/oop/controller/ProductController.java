package com.ups.oop.controller;


import com.ups.oop.dto.ProductDTO;
import com.ups.oop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get-all-product")
    public ResponseEntity getAllProduct() {
        return this.productService.getAllProduct();
    }

    @GetMapping("/get-product")
    public ResponseEntity getProductById(@RequestParam String id) {
        return this.productService.getProductById(id);
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.createProduct(productDTO);
    }

    @PutMapping("/update-product")
    public ResponseEntity updateProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.updateProduct(productDTO);
    }

    @DeleteMapping("/remove-product")
    public ResponseEntity deleteProduct(@RequestParam String id) {
        return this.productService.deleteProductById(id);
    }
}

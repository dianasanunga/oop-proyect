package com.ups.oop.service;

import com.ups.oop.dto.BranchDTO;
import com.ups.oop.dto.ProductDTO;
import com.ups.oop.entity.Branch;
import com.ups.oop.entity.Product;
import com.ups.oop.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private List<ProductDTO> productDTOList = new ArrayList<>();

    public ResponseEntity createProduct(ProductDTO productDTO) {
        String idBranch = productDTO.getidProduct();
        Optional<Product> productOptional = productRepository.findByIdProduct(idProduct);

        if (productOptional.isPresent()) {
            String errorMessage = "Product with id " + idProduct + " already exists.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } else {
            Product product = new Product();
            product.setIdProduct(idProduct);
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
    }

    public ResponseEntity getAllProduct() {
        Iterable<Product> productIterable = productRepository.findAll();
        List<ProductDTO> productsList = new ArrayList<>();

        for (Product p : productIterable) {
            ProductDTO product = new ProductDTO(p.getIdProduct(), p.getName(),
                   p.getDescription(), p.getprice());
            productsList.add(product);
        }
        if (productsList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch List not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }

    public ResponseEntity getProductById(String idProduct) {
        Optional<Product> productOptional = productRepository.findByIdProduct(idProduct);

        if (productOptional.isPresent()) {
            Product productFound = productOptional.get();
            ProductDTO product = new ProductDTO();
            product.setIdProduct(idProduct);
            product.setName(productFound.getName());
            product.setDescription(productFound.getDescription());
            product.setPrice(productFound.getPrice());
            return ResponseEntity.status(HttpStatus.OK).body(product);

        } else {
            String errorMessage = "Product with id " + idProduct + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updateProduct(ProductDTO productDTO){
        String idProduct = productDTO.getIdProduct();
        Optional<Product> productOptional = productRepository.findByIdProduct(idProduct);
        if (productOptional.isPresent()) {
            Product product = new Product();
            product.setIdBranch(idProduct);
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            String errorMessage = "Product with id " + idProduct + " not found.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity deleteProductById(String id){
        String message = "Product with id " + id;
        Optional<Product> productOptional = productRepository.findByIdProduct(id);
        if (productOptional.isPresent()) {
            productRepository.delete((productOptional.get()));
            return ResponseEntity.status(HttpStatus.OK).body(message + " removed successufuly");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");}

    }

}

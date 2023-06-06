package com.fausto.ospina.product.controller;

import com.fausto.ospina.product.dto.ProductDto;
import com.fausto.ospina.product.service.ProductService;
import com.fausto.ospina.product.utils.Exception.ProductException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable("productId") String productId) {
        try {
            return new ResponseEntity<>(service.getProduct(productId), HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/{productId}/similarids")
    public ResponseEntity<?> getSimilarIds(@PathVariable("productId") String productId) {     try {
            return new ResponseEntity<>(service.getElementsId(productId), HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}

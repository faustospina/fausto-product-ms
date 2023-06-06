package com.fausto.ospina.product.controller;

import com.fausto.ospina.product.dto.ProductDto;
import com.fausto.ospina.product.service.ProductService;
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
    public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") String productId) {

        ProductDto product = service.getProduct(productId);
        if (product!=null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{productId}/similarids")
    public ResponseEntity<List<Integer>> getSimilarIds(@PathVariable("productId") String productId) {
        return new ResponseEntity<>(service.getElementsId(productId), HttpStatus.OK);
    }


}

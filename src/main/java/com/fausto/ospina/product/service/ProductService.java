package com.fausto.ospina.product.service;

import com.fausto.ospina.product.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProduct(String id);

    List<Integer> getElementsId(String idElements);

}

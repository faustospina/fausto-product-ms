package com.fausto.ospina.product.service;

import com.fausto.ospina.product.feign.ProductFeignClient;
import com.fausto.ospina.product.dto.ProductDto;
import com.fausto.ospina.product.utils.Exception.ProductException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private  final ProductFeignClient productFeignClient;

    public ProductDto getProduct(String id){
        try {
            return productFeignClient.getSimilarIds(id);
        } catch (Exception e) {
            throw new ProductException("Error al obtener el producto: " + e.getMessage());
        }
    }

    @Override
    public List<Integer> getElementsId(String idElements) {
        try {
        return productFeignClient.getSimilarIdsElements(idElements);
        } catch (Exception e) {
            throw new ProductException("Error al obtener el producto: " + e.getMessage());
        }
    }


}

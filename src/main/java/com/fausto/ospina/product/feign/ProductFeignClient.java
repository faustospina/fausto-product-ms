package com.fausto.ospina.product.feign;

import com.fausto.ospina.product.configuration.FeignClientConfig;
import com.fausto.ospina.product.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "PRODUCT-MOCK-API", url = "${external.mock.api.base-url}", configuration = FeignClientConfig.class)
public interface ProductFeignClient {



    @GetMapping(value = "product/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ProductDto getSimilarIds(@PathVariable String productId);

    @GetMapping(value = "product/{productId}/similarids", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Integer> getSimilarIdsElements(@PathVariable String productId);

}

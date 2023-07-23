package com.example.demo.service;

import com.example.demo.models.ProductDTO;

public interface ProductService {

    public ProductDTO get(Integer id);

    public Integer update(Integer id,ProductDTO newProd);

    public Integer add(ProductDTO newProd);
}

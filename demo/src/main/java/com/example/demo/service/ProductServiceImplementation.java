package com.example.demo.service;

import com.example.demo.dao.ProductRepository;
import com.example.demo.models.Product;
import com.example.demo.models.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository repo;

    public ProductDTO get(Integer id)
    {
        Optional<Product> product = repo.findById(id);

        if(product.isEmpty())
            return new ProductDTO();

        else
            return new ProductDTO(product.get().getId(),product.get().getName(),product.get().getCategory(),product.get().getDescp());

    }

    @Override
    public Integer add(ProductDTO newProd) {

        Product product = repo.save(new Product(newProd.getId(), newProd.getName(), newProd.getCategory(), newProd.getDescp()));
        return product.getId();

    }

    @Override
    public Integer update(Integer id,ProductDTO newProd) {

        Optional<Product> product = repo.findById(id);

        if(product.isEmpty())
            return null;

        else
            return repo.save(new Product(id, newProd.getName(), newProd.getCategory(), newProd.getDescp())).getId();

    }



}

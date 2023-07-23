package com.example.demo.controller;

import com.example.demo.models.Product;
import com.example.demo.models.ProductDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("get/{id}")
    public ResponseEntity<?> get(@PathVariable(name = "id") Integer id)
    {

        ProductDTO resp = service.get(id);

        if(resp.getId()!=null)
            return new ResponseEntity<ProductDTO>(resp, HttpStatus.FOUND);

        else
            return new ResponseEntity<String>("Product not Found", HttpStatus.NOT_FOUND);

    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody ProductDTO newProd)
    {

        Integer pId = service.add(newProd);

        if(pId!=null)
            return new ResponseEntity<String>("Product Id: "+pId+" added successfully", HttpStatus.CREATED);

        else
            return new ResponseEntity<String>("Error adding product", HttpStatus.BAD_REQUEST);

    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Integer id,@RequestBody ProductDTO newProd)
    {

        Integer upId = service.update(id,newProd);

        if(upId!=null)
            return new ResponseEntity<String>("Product Id: "+upId+" updated successfully", HttpStatus.NOT_FOUND);

        else
            return new ResponseEntity<String>("Product not Found", HttpStatus.NOT_FOUND);

    }

}

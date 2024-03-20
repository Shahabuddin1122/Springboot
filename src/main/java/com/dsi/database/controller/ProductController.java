package com.dsi.database.controller;

import com.dsi.database.dao.FilterDao;
import com.dsi.database.model.Products;
import com.dsi.database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public   ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("/save")
    public ResponseEntity<?> SaveProducts(@RequestBody Products products){
        return productService.saveProducts(products);
    }

    @PostMapping("/filter")
    public ResponseEntity<?> getFilterData(@RequestBody FilterDao filterDao){
        return productService.filteredProduct(filterDao);
    }

}

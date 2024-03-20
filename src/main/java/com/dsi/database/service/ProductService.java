package com.dsi.database.service;

import com.dsi.database.dao.FilterDao;
import com.dsi.database.model.Products;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ResponseEntity<?> saveProducts(Products products);

    ResponseEntity<?> getAllProducts();

    ResponseEntity<?> filteredProduct(FilterDao filterDao);
}

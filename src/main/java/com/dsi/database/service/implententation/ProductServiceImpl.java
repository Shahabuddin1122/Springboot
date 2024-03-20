package com.dsi.database.service.implententation;

import com.dsi.database.dao.FilterDao;
import com.dsi.database.model.Products;
import com.dsi.database.repository.ProductRepository;
import com.dsi.database.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public ProductRepository productRepository;
    @Override
    public ResponseEntity<?> saveProducts(Products products) {
        Products products1 = productRepository.save(products);
        return new ResponseEntity<>(products1, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> filteredProduct(FilterDao filterDao) {
//        List<Products> products = productRepository.findProductsByCategoryAndSubCategory(filterDao.getCategory(),filterDao.getSubCategory());
        List<Products> products = productRepository.filter(filterDao);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}

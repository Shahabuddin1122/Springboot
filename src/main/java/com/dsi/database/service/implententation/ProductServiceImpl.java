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

    @Autowired
    public RedisServiceImpl redisService;

    @Override
    public ResponseEntity<?> saveProducts(Products products) {
        Products products1 = productRepository.save(products);
        return new ResponseEntity<>(products1, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getAllProducts() {

        String cacheData = redisService.getValue("products");

        if(cacheData != null){
            return new ResponseEntity<>(cacheData,HttpStatus.OK);
        }
        Object products = productRepository.findAll();
        redisService.setValue("products",products.toString());
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> filteredProduct(FilterDao filterDao) {
//        List<Products> products = productRepository.findProductsByCategoryAndSubCategory(filterDao.getCategory(),filterDao.getSubCategory());
        List<Products> products = productRepository.filter(filterDao);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}

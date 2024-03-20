package com.dsi.database.repository;

import com.dsi.database.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long>,CustomRepository {

    List<Products> findProductsByCategoryAndSubCategory(String category,String subCategory);
}

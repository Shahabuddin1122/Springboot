package com.dsi.database.repository;

import com.dsi.database.dao.FilterDao;
import com.dsi.database.model.Products;

import java.util.List;

public interface CustomRepository {
    List<Products> filter(FilterDao filterDao);
}

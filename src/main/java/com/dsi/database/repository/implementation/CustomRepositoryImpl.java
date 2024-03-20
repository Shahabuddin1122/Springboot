package com.dsi.database.repository.implementation;

import com.dsi.database.dao.CategoryFilter;
import com.dsi.database.dao.FilterDao;
import com.dsi.database.model.Products;
import com.dsi.database.repository.CustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class CustomRepositoryImpl implements CustomRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Products> filter(FilterDao filterDao) {
        StringBuilder queryBuilder = new StringBuilder("SELECT p FROM Products p WHERE");

        if(filterDao.getStartingPrice() < filterDao.getEndPrice()){
            queryBuilder.append(" (p.Price between :startingPrice and :endPrice) ");
        }

        List<String> categories = new ArrayList<>();
        List<String> subCategories = new ArrayList<>();

        if(filterDao.getCategory() != null && !filterDao.getCategory().isEmpty()){
            for(CategoryFilter x:filterDao.getCategory()){
                if(x.getSubCategories() != null && !x.getSubCategories().isEmpty()){
                    subCategories.addAll(x.getSubCategories());
                } else {
                    categories.add(x.getName());
                }
            }
            if(!categories.isEmpty() && !subCategories.isEmpty()){
                queryBuilder.append("and (p.category IN(:category)) or (p.subCategory IN(:subCategory)) ");
            } else if (!subCategories.isEmpty()) {
                queryBuilder.append("and p.subCategory IN(:subCategory) ");
            }
            else {
                queryBuilder.append("and p.category IN(:category)");
            }
        }


        TypedQuery<Products> query = entityManager.createQuery(queryBuilder.toString(), Products.class);

        if(!subCategories.isEmpty()){
            query.setParameter("subCategory", subCategories);
        }
        if(!categories.isEmpty()){
            query.setParameter("category", categories);
        }


        query.setParameter("startingPrice", filterDao.getStartingPrice());
        query.setParameter("endPrice", filterDao.getEndPrice());
        return query.getResultList();
    }
}

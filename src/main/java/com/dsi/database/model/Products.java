package com.dsi.database.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Products extends BaseEntity<Long>{
    private String name;
    private String category;
    private String subCategory;
    private String description;
    private Long Price;
}

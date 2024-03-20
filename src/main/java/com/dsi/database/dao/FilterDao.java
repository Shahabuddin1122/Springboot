package com.dsi.database.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterDao {
    private List<CategoryFilter> category;
    private int startingPrice;
    private int endPrice;

}


//package com.dsi.database.dao;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class FilterDao {
//    private String category;
//    private String subCategory;
//    private int startingPrice;
//    private int endPrice;
//}

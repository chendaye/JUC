package top.chendaye666.springbootwxmeet.service;

import top.chendaye666.springbootwxmeet.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * Created by 廖师兄
 * 2017-05-09 10:12
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}

package top.chendaye666.springbootwxmeet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.chendaye666.springbootwxmeet.dataobject.ProductCategory;
import top.chendaye666.springbootwxmeet.repository.ProductCategoryRepository;
import top.chendaye666.springbootwxmeet.service.ProductCategoryService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer id) {
        // Optional 是一个对象容器，内容可以为空
        Optional<ProductCategory> byId = repository.findById(id);
        return byId.get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> typeList) {
        return repository.findByCategoryTypeIn(typeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}

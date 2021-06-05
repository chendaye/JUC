package top.chendaye666.springbootwxmeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.chendaye666.springbootwxmeet.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    // 方法名就是sql，查看jpa文档
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}

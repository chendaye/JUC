package top.chendaye666.springbootwxmeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.chendaye666.springbootwxmeet.dataobject.ProductInfo;

import java.util.List;

// <表类型，主键类型>
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer status);
}

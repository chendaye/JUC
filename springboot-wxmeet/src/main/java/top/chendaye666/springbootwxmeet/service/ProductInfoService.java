package top.chendaye666.springbootwxmeet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.chendaye666.springbootwxmeet.dataobject.ProductInfo;

import java.util.List;

public interface ProductInfoService {
    ProductInfo findOne(String id);

    /**
     * 所有上架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //todo:上架

    //todo: 下架
}

package top.chendaye666.springbootwxmeet.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.chendaye666.springbootwxmeet.dataobject.ProductInfo;
import top.chendaye666.springbootwxmeet.dto.CartDTO;

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

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);
}

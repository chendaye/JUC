package top.chendaye666.springbootwxmeet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import top.chendaye666.springbootwxmeet.dataobject.ProductInfo;
import top.chendaye666.springbootwxmeet.enums.ProductStatusEnum;
import top.chendaye666.springbootwxmeet.repository.ProductInfoRepository;
import top.chendaye666.springbootwxmeet.service.ProductInfoService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String id) {
        Optional<ProductInfo> byId = repository.findById(id);
        return byId.get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> byProductStatus = repository.findByProductStatus(ProductStatusEnum.UP.getCode());
        return byProductStatus;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }
}

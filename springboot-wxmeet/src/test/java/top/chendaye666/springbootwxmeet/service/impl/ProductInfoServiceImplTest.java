package top.chendaye666.springbootwxmeet.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import top.chendaye666.springbootwxmeet.dataobject.ProductInfo;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductInfoServiceImplTest {

    @Autowired
    ProductInfoServiceImpl productInfoService;
    @Test
    void findOne() {
    }

    @Test
    void findUpAll() {
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(1, 3);
        Page<ProductInfo> all = productInfoService.findAll(pageRequest);
        assertNotEquals(0, all.getTotalElements());
    }

    @Test
    void save() {
    }
}
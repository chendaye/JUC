package top.chendaye666.springbootwxmeet.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.chendaye666.springbootwxmeet.dataobject.ProductInfo;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("11111");
        productInfo.setProductName("油焖大虾");
        productInfo.setProductPrice(new BigDecimal(267.5));
        productInfo.setProductStock(10);
        productInfo.setProductDescription("麻辣鲜香");
        productInfo.setProductIcon("https://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(1);
        ProductInfo save = repository.save(productInfo);
        assertNotNull(save);
    }

    @Test
    public void findByProductStatusTest(){
        List<ProductInfo> byProductStatus = repository.findByProductStatus(1);
        assertNotEquals(0, byProductStatus.size());
    }
}
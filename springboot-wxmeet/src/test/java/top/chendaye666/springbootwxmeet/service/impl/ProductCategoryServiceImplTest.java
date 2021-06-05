package top.chendaye666.springbootwxmeet.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.chendaye666.springbootwxmeet.dataobject.ProductCategory;

import javax.xml.ws.soap.Addressing;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductCategoryServiceImplTest {

    @Autowired
    ProductCategoryServiceImpl impl;
    @Test
    void findOne() {
        ProductCategory one = impl.findOne(1);
//        System.out.printf(one.toString());
        assertNotNull(one);
    }

    @Test
    void findAll() {
        List<ProductCategory> all = impl.findAll();
        assertNotNull(all);
    }

    @Test
    void findByCategoryTypeIn() {
        List<ProductCategory> byCategoryTypeIn = impl.findByCategoryTypeIn(Arrays.asList(0, 1, 2));
        assertNotEquals(0, byCategoryTypeIn.size());
    }

    @Test
    void save() {
        ProductCategory productCategory = new ProductCategory("武大", 1);
        ProductCategory save = impl.save(productCategory);
        assertNotNull(save);
    }
}
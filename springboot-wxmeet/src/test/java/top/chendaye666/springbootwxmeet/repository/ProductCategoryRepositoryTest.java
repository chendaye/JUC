package top.chendaye666.springbootwxmeet.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.chendaye666.springbootwxmeet.dataobject.ProductCategory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        List<ProductCategory> all = productCategoryRepository.findAll();
        for (ProductCategory productCategory : all){
            System.out.println(productCategory);
        }
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(3);
        productCategory.setCategoryName("green");
        productCategory.setCategoryType(1);
        productCategoryRepository.save(productCategory);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("yellow22");
        productCategory.setCategoryType(1);
        ProductCategory save = productCategoryRepository.save(productCategory);
        assertNotNull(save);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> typeList = Arrays.asList(0,1,2);
        List<ProductCategory> byCategoryTypeIn = productCategoryRepository.findByCategoryTypeIn(typeList);
        assertNotEquals(0, byCategoryTypeIn.size());
    }

}
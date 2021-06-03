package top.chendaye666.mall.service.test;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import top.chendaye666.mall.common.ServerResponse;
import top.chendaye666.mall.service.IProductService;
import top.chendaye666.mall.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by geely
 */
public class ProductServiceTest extends TestBase {

    @Autowired
    private IProductService iProductService;

    @Test
    public void testIProductService(){
        ServerResponse<PageInfo> result =  iProductService.getProductByKeywordCategory("iphone",2,1,5,"price_desc");
        System.out.println(result);
    }

    public static void main(String[] args) {
        List<String> images = Lists.newArrayList();
        images.add("mmall/aa.jpg");
        images.add("mmall/bb.jpg");
        images.add("mmall/cc.jpg");
        images.add("mmall/dd.jpg");
        images.add("mmall/ee.jpg");
//        ["mmall/aa.jpg","mmall/bb.jpg","mmall/cc.jpg","mmall/dd.jpg","mmall/ee.jpg"]
    }
}

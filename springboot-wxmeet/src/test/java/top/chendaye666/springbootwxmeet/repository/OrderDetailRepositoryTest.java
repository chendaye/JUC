package top.chendaye666.springbootwxmeet.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.chendaye666.springbootwxmeet.dataobject.OrderDetail;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("234");
        orderDetail.setOrderId("111");
        orderDetail.setProductIcon("http://xxxx.png");
        orderDetail.setProductId("11111");
        orderDetail.setProductName("油焖大虾");
        orderDetail.setProductPrice(new BigDecimal(225.78));
        orderDetail.setProductQuantity(1);
        OrderDetail save = repository.save(orderDetail);
        assertNotNull(save);
    }
    @Test
    void findByOrderId() {
        List<OrderDetail> byOrderId = repository.findByOrderId("111");
//        assertNotEquals(0, byOrderId.size());
        assertTrue(byOrderId.size() > 0, "通过ID查询订单");
    }
}
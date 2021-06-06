package top.chendaye666.springbootwxmeet.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import top.chendaye666.springbootwxmeet.dataobject.OrderMaster;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    OrderMasterRepository repository;

    private String openId = "123";

    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerName("彭于晏");
        orderMaster.setBuyerPhone("15271834241");
        orderMaster.setBuyerAddress("清江山水");
        orderMaster.setBuyerOpenid(openId);
        orderMaster.setOrderAmount(new BigDecimal(123.48));
        orderMaster.setOrderId("111");
        OrderMaster save = repository.save(orderMaster);
        assertNotNull(save);
    }

    @Test
    public void findByBuyerOpenId(){
        PageRequest of = PageRequest.of(1, 10);
        Page<OrderMaster> byBuyerOpenid = repository.findByBuyerOpenid(openId, of);
        System.out.printf(String.valueOf(byBuyerOpenid.getTotalElements()));
        assertNotEquals(0, byBuyerOpenid.getTotalElements());
    }
}
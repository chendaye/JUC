package top.chendaye666.springbootwxmeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.chendaye666.springbootwxmeet.dataobject.OrderDetail;

import java.util.List;

/**
 * Created by 廖师兄
 * 2017-06-11 17:28
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}

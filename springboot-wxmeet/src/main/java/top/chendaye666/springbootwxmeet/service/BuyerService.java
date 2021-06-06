package top.chendaye666.springbootwxmeet.service;

import top.chendaye666.springbootwxmeet.dto.OrderDTO;

/**
 * 买家
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}

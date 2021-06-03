package top.chendaye666.mall.service.impl;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import top.chendaye666.mall.common.ServerResponse;
import top.chendaye666.mall.service.IOrderService;
import top.chendaye666.mall.vo.OrderVo;

import java.util.Map;

@Service("iOrderService")
public class OrderServiceImpl implements IOrderService {
    @Override
    public ServerResponse pay(Long orderNo, Integer userId, String path) {
        return null;
    }

    @Override
    public ServerResponse aliCallback(Map<String, String> params) {
        return null;
    }

    @Override
    public ServerResponse queryOrderPayStatus(Integer userId, Long orderNo) {
        return null;
    }

    @Override
    public ServerResponse createOrder(Integer userId, Integer shippingId) {
        return null;
    }

    @Override
    public ServerResponse<String> cancel(Integer userId, Long orderNo) {
        return null;
    }

    @Override
    public ServerResponse getOrderCartProduct(Integer userId) {
        return null;
    }

    @Override
    public ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo) {
        return null;
    }

    @Override
    public ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public ServerResponse<PageInfo> manageList(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public ServerResponse<OrderVo> manageDetail(Long orderNo) {
        return null;
    }

    @Override
    public ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public ServerResponse<String> manageSendGoods(Long orderNo) {
        return null;
    }
}

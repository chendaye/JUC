package top.chendaye666.mall.service;

import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import top.chendaye666.mall.common.ServerResponse;
import top.chendaye666.mall.pojo.Shipping;


public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);
    ServerResponse<String> del(Integer userId, Integer shippingId);
    ServerResponse update(Integer userId, Shipping shipping);
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);
    ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize);

}

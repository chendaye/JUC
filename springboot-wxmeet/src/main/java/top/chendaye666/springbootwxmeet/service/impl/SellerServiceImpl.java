package top.chendaye666.springbootwxmeet.service.impl;

import top.chendaye666.springbootwxmeet.dataobject.SellerInfo;
import top.chendaye666.springbootwxmeet.repository.SellerInfoRepository;
import top.chendaye666.springbootwxmeet.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 廖师兄
 * 2017-07-29 23:15
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}

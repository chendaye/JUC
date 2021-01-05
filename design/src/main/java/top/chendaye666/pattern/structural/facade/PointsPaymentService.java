package top.chendaye666.pattern.structural.facade;

/**
 * Created by geely
 */
public class PointsPaymentService extends GiftExchangeService {
    public boolean pay(PointsGift pointsGift){
        //扣减积分
        System.out.println("支付"+pointsGift.getName()+" 积分成功");
        return true;
    }

}

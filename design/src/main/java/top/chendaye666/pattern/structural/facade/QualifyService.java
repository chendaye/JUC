package top.chendaye666.pattern.structural.facade;

/**
 * Created by geely
 */
public class QualifyService extends GiftExchangeService {
    public boolean isAvailable(PointsGift pointsGift){
        System.out.println("校验"+pointsGift.getName()+" 积分资格通过,库存通过");
        return true;
    }
}

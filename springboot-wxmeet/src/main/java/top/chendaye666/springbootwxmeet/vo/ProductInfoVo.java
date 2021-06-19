package top.chendaye666.springbootwxmeet.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 返回给前端很多时候需要序列化
 * 商品详情
 * Created by 廖师兄
 * 2017-05-12 14:25
 */
@Data
public class ProductInfoVo implements Serializable {

    // 序列化需要一个唯一ID，Serializable
    private static final long serialVersionUID = -3895834204864685262L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}

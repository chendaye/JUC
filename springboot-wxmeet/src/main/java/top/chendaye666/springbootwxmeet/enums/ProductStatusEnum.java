package top.chendaye666.springbootwxmeet.enums;

import lombok.Getter;

/**
 * 用枚举类型来保存 项目中的状态
 */
@Getter // 生成getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架")
    ;
    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}

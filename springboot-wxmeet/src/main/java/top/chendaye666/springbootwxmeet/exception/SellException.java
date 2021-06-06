package top.chendaye666.springbootwxmeet.exception;

import top.chendaye666.springbootwxmeet.enums.ResultEnum;
import lombok.Getter;

/**
 * 自己封装一个异常类
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}

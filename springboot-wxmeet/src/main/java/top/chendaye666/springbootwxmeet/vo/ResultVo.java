package top.chendaye666.springbootwxmeet.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import top.chendaye666.springbootwxmeet.enums.ResponseCodeEnum;

/**
 * 视图对象：定义返回的数据格式
 */
@Data
public class ResultVo<T> {
    // 错误码
    private Integer code;

    /** 提示信息*/
    private String msg;

    /**返回数据*/
    private T data;

    private ResultVo(int code){
        this.code = code;
    }
    private ResultVo(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    private ResultVo(int code, T data){
        this.code = code;
        this.data = data;
    }

    private ResultVo(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.code == ResponseCodeEnum.SUCCESS.getCode();
    }
    public static <T> ResultVo<T> success(){
        return new ResultVo<T>(ResponseCodeEnum.SUCCESS.getCode());
    }

    public static <T> ResultVo<T> successMsg(String msg){
        return new ResultVo<T>(ResponseCodeEnum.SUCCESS.getCode(), msg);
    }
    public static <T> ResultVo<T> successData(T data){
        return new ResultVo<T>(ResponseCodeEnum.SUCCESS.getCode(),data);
    }
    public static <T> ResultVo<T> successMsgData(String msg, T data){
        return new ResultVo<T>(ResponseCodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResultVo<T> error(){
        return new ResultVo<T>(ResponseCodeEnum.ERROR.getCode());
    }

    public static <T> ResultVo<T> errorMsg(String msg){
        return new ResultVo<T>(ResponseCodeEnum.ERROR.getCode(), msg);
    }

    public static <T> ResultVo<T> errorMsgCode(String msg, int code){
        return new ResultVo<T>(code, msg);
    }



}

package top.chendaye666.springbootwxmeet.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import top.chendaye666.springbootwxmeet.enums.ResponseCodeEnum;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 */
@Data
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = 3068837394742385883L;

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;

    private ResultVo(){
    }
    private ResultVo(String msg){
        this.msg = msg;
    }

    private ResultVo(int code){
        this.code = code;
    }


    private ResultVo(int code, T data){
        this.code = code;
        this.data = data;
    }
    private ResultVo(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    private ResultVo(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @JsonIgnore // 使之不在序列化的结果中
    public boolean isSuccess(){
        return this.code == ResponseCodeEnum.SUCCESS.getCode();
    }

    public static <T> ResultVo<T> createBySuccess(){
        return new ResultVo<T>(ResponseCodeEnum.SUCCESS.getCode());
    }
    public static <T> ResultVo<T> createBySuccessMessage(String msg){
        return new ResultVo<T>(ResponseCodeEnum.SUCCESS.getCode(), msg);
    }

    public static <T> ResultVo<T> createBySuccess(T data){
        return new ResultVo<T>(ResponseCodeEnum.SUCCESS.getCode(), data);
    }

    public static <T> ResultVo<T> createBySuccess(String msg, T data){
        return new ResultVo<T>(ResponseCodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResultVo<T> createByError(){
        return new ResultVo<T>(ResponseCodeEnum.ERROR.getCode(), ResponseCodeEnum.ERROR.getDesc());
    }

    public static <T> ResultVo<T> createByErrorMessage(String error){
        return new ResultVo<T>(ResponseCodeEnum.ERROR.getCode(), error);
    }
    public static <T> ResultVo<T> createByErrorCodeMessage(int code, String error){
        return new ResultVo<T>(code, error);
    }
    
}

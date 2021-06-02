package top.chendaye666.controller;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.chendaye666.pojo.Param;

@Controller
public class JsonController {

    @ResponseBody // 不走视图解析器,直接返回
    @RequestMapping("/method1")
    public String json01(){

        Param chendaye = new Param(10, "chendaye");

        return chendaye.toString();
    }
}

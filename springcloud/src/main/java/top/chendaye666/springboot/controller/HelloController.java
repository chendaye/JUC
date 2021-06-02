package top.chendaye666.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 本身就是 spring的组件
@RestController
public class HelloController {
    // 接口
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}

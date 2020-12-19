package top.chendaye666.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.chendaye666.pojo.Param;

@Controller
@RequestMapping("param")
public class ParamController {

    // localhost/param/method01?name=***
    @GetMapping("/method01")
    public String test(@RequestParam("name") String name, Model model){
        // 接收参数
        System.out.println("参数"+name);
        // 向前端传数据
        model.addAttribute("data", name);

        // 指定视图
        return "hello";
    }

    // 接收前端的对象
    // localhost/param/method01?id=123 &name=*** 用 param 类去匹配
    @GetMapping("/method02")
    public String test02(Param param){
        return "test";
    }
}

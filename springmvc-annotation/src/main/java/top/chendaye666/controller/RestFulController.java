package top.chendaye666.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController{
    //映射访问路径 rest 风格 url
//    @RequestMapping(name = "/hello/{p1}/{p2}", method = RequestMethod.GET)
    @GetMapping("/hello/{p1}/{p2}")
    public String index(@PathVariable int p1, @PathVariable int p2, Model model){
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg",p1+p2);
        //返回视图位置
        return "hello";
    }
}
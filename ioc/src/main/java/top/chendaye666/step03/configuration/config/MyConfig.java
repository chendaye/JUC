package top.chendaye666.step03.configuration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import top.chendaye666.step03.configuration.pojo.User;

// 用 java 代替 xml 文件; @Configuration 也是一个@Compoenent
// 可以做 beans.xml 的所有事情
@Configuration
@ComponentScan("top.chendaye666.step03.configuration")
@Import(MyConfig02.class)
public class MyConfig {
    // 注册一个类， 方法名=bean 中的 id 返回值=bean的class
    @Bean
    public User getUser(){
        return new User();
    }
}

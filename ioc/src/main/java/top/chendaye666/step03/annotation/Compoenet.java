package top.chendaye666.step03.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Scope("singleton")
public class Compoenet {
    @Value("chen")
    private String name;
    public void say(){
        System.out.println("compoenet");
    }

    public void name(){
        System.out.println(name);
    }

}

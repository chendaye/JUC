package proxy.springaop.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // 标注为一个切面
public class AnnotationPointcut {
    @Before("execution(* proxy.springaop.service.UserServiceImp.*(..))")
    public void before(){
        System.out.println("AnnotationPointcut-before");
    }

    @After("execution(* proxy.springaop.service.UserServiceImp.*(..))")
    public void after(){
        System.out.println("AnnotationPointcut-after");
    }


    @Around("execution(* proxy.springaop.service.UserServiceImp.*(..))")
    public void around(ProceedingJoinPoint jp){
        System.out.println("环绕前");
        Signature signature = jp.getSignature();
        System.out.println(signature.getName());
        System.out.println("环绕后");
    }
}

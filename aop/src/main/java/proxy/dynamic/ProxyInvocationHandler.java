package proxy.dynamic;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * todo: 用来自动生成代理类
 *      - java.lang.reflect.Proxy 调用InvocationHandler.invoke 生成代理类
 *      - java.lang.reflect.InvocationHandler invoke 提供生成代理类的逻辑
 */
public class ProxyInvocationHandler implements InvocationHandler {
    private Object obj;



    public void setobj(Object obj) {
        this.obj = obj;
    }

    //todo：生成代理类的逻辑。生成代理，类. 基于反射实现
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(obj, args);
        return invoke;
    }

    //生成代理
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);

    }

    // 干其他事情
    public void seeHouse(){
        System.out.println("seeHouse");
    }
}

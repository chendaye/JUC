package proxy.dynamic;

import proxy.statics.step01.Landlady;
import proxy.statics.step01.Rent;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        Landlady landlady = new Landlady();

        // 生成代理类
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setobj(landlady);
        Rent proxy = (Rent)proxyInvocationHandler.getProxy();

        proxy.rentHouse();
    }
}

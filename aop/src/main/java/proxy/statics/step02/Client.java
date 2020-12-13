package proxy.statics.step02;

/**
 * todo: 代理模式 有点像门脸模式
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImp userServiceImp = new UserServiceImp();

        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserServiceImp(userServiceImp);
        userServiceProxy.add();

    }
}

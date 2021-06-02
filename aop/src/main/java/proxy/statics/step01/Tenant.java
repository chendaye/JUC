package proxy.statics.step01;

/**
 * 租客
 */
public class Tenant {
    public static void main(String[] args) {
        Landlady landlady = new Landlady();
        landlady.rentHouse();

        // 代理
        Proxy proxy = new Proxy(landlady);
        proxy.rentHouse();
    }
}

package proxy.statics.step01;

/**
 * todo:代理模式组成：公共的事情让代理去做
 *      - 接口
 *      - 客户端(租客)
 *      - 真实角色(房东)
 *      - 代理角色(中介)
 */
public class Proxy implements Rent {
    private Landlady landlady;

    public Proxy(){

    }

    public Proxy(Landlady landlady) {
        this.landlady = landlady;
    }


    @Override
    public void rentHouse() {
        landlady.rentHouse();
        // 代理可以有其他操作
        seeHouse();
        contract();
        System.out.println("代理中介，帮房东租房");
    }

    // 看房
    public void seeHouse(){
        System.out.println("中介代理看房");
    }

    // 签合同
    public void contract(){
        System.out.println("中介签合同");
    }
}

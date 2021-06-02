package proxy.statics.step01;

public class Landlady implements Rent{
    @Override
    public void rentHouse() {
        System.out.println("房东租房");
    }
}

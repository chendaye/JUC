package top.chendaye666.pattern.structural.adapter.classadapter;

/**
 * Created by geely
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        //...
        super.adapteeRequest();
        //...
    }
}

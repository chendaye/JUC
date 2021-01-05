package top.chendaye666.pattern.behavioral.visitor;

public interface Visitable<T extends Visitor> {

     void accept(T visitor);

}

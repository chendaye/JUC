package top.chendaye666.pattern.behavioral.visitor;

public interface RouteVisitor extends Visitor {

    void visit(RouteRequestExecutor routeRequestExecutor);
}

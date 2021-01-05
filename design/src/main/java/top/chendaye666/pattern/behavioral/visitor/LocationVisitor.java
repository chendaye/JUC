package top.chendaye666.pattern.behavioral.visitor;

public interface LocationVisitor extends Visitor {

    void visit(LocationRequestExecutor locationRequestExecutor);
}

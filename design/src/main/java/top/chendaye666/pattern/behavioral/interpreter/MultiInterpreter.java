package top.chendaye666.pattern.behavioral.interpreter;



 
public class MultiInterpreter implements Interpreter {
    private Interpreter firstInterpreter;
    private Interpreter secondInterpreter;

    public MultiInterpreter(Interpreter firstInterpreter, Interpreter secondInterpreter) {
        this.firstInterpreter = firstInterpreter;
        this.secondInterpreter = secondInterpreter;
    }

    @Override
    public int interpret() {
        return firstInterpreter.interpret() * secondInterpreter.interpret();
    }

    @Override
    public String toString() {
        return "*";
    }
}

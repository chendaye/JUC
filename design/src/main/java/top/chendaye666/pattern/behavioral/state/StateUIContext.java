package top.chendaye666.pattern.behavioral.state;

import java.io.PrintWriter;

public class StateUIContext {

    private GreetingState greetingState;

    public void setGreetingState(GreetingState greetingState) {
        this.greetingState = greetingState;
    }

    public void create(PrintWriter printWriter) {
        printWriter.write(greetingState.create());
    }
}

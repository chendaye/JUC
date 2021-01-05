package top.chendaye666.pattern.behavioral.state;

import java.io.PrintWriter;
import java.util.Date;

public class StateMain {

    public static void main(String[] args) {

        StateUIContext stateUIContext = new StateUIContext();

        try(PrintWriter printWriter = new PrintWriter(System.out)) {
            stateUIContext.setGreetingState(new AnonymousGreetingState());
            stateUIContext.create(printWriter);
            printWriter.write("\n");
            stateUIContext.setGreetingState(new LoggedInGreetingState("someone"));
            stateUIContext.create(printWriter);
            printWriter.write("\n");
            stateUIContext.setGreetingState(new AdminGreetingState("admin",new Date()));
            stateUIContext.create(printWriter);
            printWriter.write("\n");
        }
    }
}

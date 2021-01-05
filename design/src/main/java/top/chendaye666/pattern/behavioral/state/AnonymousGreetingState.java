package top.chendaye666.pattern.behavioral.state;

public class AnonymousGreetingState implements GreetingState {

    private static final String FOOTER_MESSAGE = "<p><Hello anonymous user!</p>";

    @Override
    public String create() {
        return FOOTER_MESSAGE;
    }

}

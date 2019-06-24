package rpn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");

        InMemoryBus bus = new InMemoryBus();
        bus.subscribe("expression-type", new TokenizerConsumer(bus));

        bus.publish(new ExpressionMessage(""));
    }
}

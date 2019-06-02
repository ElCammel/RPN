package rpn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLI {
    public static final void main(String[] args) {
        String expression = Stream.of(args).collect(Collectors.joining(" "));

        System.out.println("About to evaluate '" + expression + "'");
        List<Operator> operatorsList = new ArrayList<>();

        operatorsList.add(new Add("+"));
        operatorsList.add(new Substract("-"));
        operatorsList.add(new Multiply("*"));
        operatorsList.add(new Divide("/"));

        Operators operators = new Operators(operatorsList);

        RPNCalculator rpnCalculator = new RPNCalculator();
        Double result = rpnCalculator.evaluate(expression, operators);

        System.out.println("> " + result);
    }
}

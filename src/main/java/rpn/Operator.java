package rpn;

import java.util.Stack;

public interface Operator {

    Stack<Double> calculate(Stack<Double> tokenStack);

    String getValue();
}

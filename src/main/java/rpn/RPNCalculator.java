package rpn;

import java.util.Stack;

public class RPNCalculator {

    public Double evaluate(String expression, Operators operators) {
        Stack<Double> stack = new Stack<Double>();

        String[] tokens = Tokenizer.tokenize(expression);

        for (String token : tokens) {
            Operator operator = operators.findOperator(token);

            if (operator == null) { //push to stack if it is a number
                stack.push(Double.valueOf(token));
            } else {//pop numbers from stack if it is an operator
                stack = operator.calculate(stack);
            }
        }

        Double returnValue = Double.valueOf(stack.pop());

        return returnValue;
    }


}

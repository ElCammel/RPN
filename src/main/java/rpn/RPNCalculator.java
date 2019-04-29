package rpn;

import java.util.Stack;

public class RPNCalculator {

    private static String operators = "+-*/";
    private static Stack<String> stack = new Stack<String>();

    public static Double evaluate(String[] tokens) {

        stack.clear();

        for (String token : tokens) {
            if (!operators.contains(token)) { //push to stack if it is a number
                stack.push(token);
            } else {//pop numbers from stack if it is an operator
                manageNumbers(token);
            }
        }

        Double returnValue = Double.valueOf(stack.pop());

        return returnValue;
    }

    private static void manageNumbers(String token){
        Double a = Double.valueOf(stack.pop());
        Double b = Double.valueOf(stack.pop());

        switch (token) {
            case "+":
                stack.push(String.valueOf(a + b));
                break;
            case "-":
                stack.push(String.valueOf(b - a));
                break;
            case "*":
                stack.push(String.valueOf(a * b));
                break;
            case "/":
                stack.push(String.valueOf(b / a));
                break;
        }
    }

}

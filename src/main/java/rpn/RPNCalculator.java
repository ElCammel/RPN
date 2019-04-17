package rpn;

import java.util.Stack;

public class RPNCalculator {

    private static String operators = "+-*/";
    private static Stack<String> stack = new Stack<String>();

    public static int evaluate(String[] tokens) {

        for (String token : tokens) {
            if (!operators.contains(token)) { //push to stack if it is a number
                stack.push(token);
            } else {//pop numbers from stack if it is an operator
                manageNumbers(token);
            }
        }

        return Integer.valueOf(stack.pop());
    }

    private static void manageNumbers(String token){
        int a = Integer.valueOf(stack.pop());
        int b = Integer.valueOf(stack.pop());

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

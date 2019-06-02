package rpn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CLITest {

    private Operators getOperators(){
        List<Operator> operatorsList = new ArrayList<>();

        Operator add = new Add("+");
        Operator substract = new Substract("-");
        Operator multiply = new Multiply("*");
        Operator divide = new Divide("/");

        operatorsList.add(add);
        operatorsList.add(substract);
        operatorsList.add(multiply);
        operatorsList.add(divide);

        return new Operators(operatorsList);
    }

    @Test
    public void should_evaluate_single_digit_constant() {
        String tokens = "5";
        Operators operators = getOperators();
        RPNCalculator rpnCalculator = new RPNCalculator();

        assertThat(rpnCalculator.evaluate(tokens, operators)).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        String tokens = "17";
        Operators operators = getOperators();
        RPNCalculator rpnCalculator = new RPNCalculator();

        assertThat(rpnCalculator.evaluate(tokens, operators)).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_addition() {
        String tokens = "17 5 +";
        Operators operators = getOperators();
        RPNCalculator rpnCalculator = new RPNCalculator();

        assertThat(rpnCalculator.evaluate(tokens, operators)).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        String tokens = "2 3 5 + +";
        Operators operators = getOperators();
        RPNCalculator rpnCalculator = new RPNCalculator();

        assertThat(rpnCalculator.evaluate(tokens, operators)).isEqualTo(10);
    }
    
        @Test
    public void should_evaluate_simple_substraction() {
        String tokens = "17 5 -";
        Operators operators = getOperators();
        RPNCalculator rpnCalculator = new RPNCalculator();

        assertThat(rpnCalculator.evaluate(tokens, operators)).isEqualTo(12);
    }

    @Test
    public void should_evaluate_more_complex_substraction() {
        String tokens = "2 3 5 - -";
        Operators operators = getOperators();
        RPNCalculator rpnCalculator = new RPNCalculator();

        assertThat(rpnCalculator.evaluate(tokens, operators)).isEqualTo(4);
    }
    
            @Test
    public void should_evaluate_simple_mutliplication() {
        String tokens = "17 5 *";
        Operators operators = getOperators();
        RPNCalculator rpnCalculator = new RPNCalculator();

        assertThat(rpnCalculator.evaluate(tokens, operators)).isEqualTo(85);
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        String tokens = "2 3 5 * *";
        Operators operators = getOperators();
        RPNCalculator rpnCalculator = new RPNCalculator();

        assertThat(rpnCalculator.evaluate(tokens, operators)).isEqualTo(30);
    }
    
            @Test
    public void should_evaluate_simple_division() {
        String tokens = "17 5 /";
        Operators operators = getOperators();
        RPNCalculator rpnCalculator = new RPNCalculator();

        assertThat(rpnCalculator.evaluate(tokens, operators)).isEqualTo(3.4);
    }

    @Test
    public void should_evaluate_0_divided() {
        String tokens = "2 0 /";
        Operators operators = getOperators();
        RPNCalculator rpnCalculator = new RPNCalculator();

        assertThat(rpnCalculator.evaluate(tokens, operators)).isEqualTo(Double.POSITIVE_INFINITY);
    }
    
}

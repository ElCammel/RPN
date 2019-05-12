package rpn;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CLITest {

    @Test
    public void should_evaluate_single_digit_constant() {
        String[] tokens = {"5"};
        assertThat(RPNCalculator.evaluate(tokens)).isEqualTo(5);
    }

    @Test
    public void should_evaluate_multiple_digits_constant() {
        String[] tokens = {"17"};
        assertThat(RPNCalculator.evaluate(tokens)).isEqualTo(17);
    }

    @Test
    public void should_evaluate_simple_addition() {
        String[] tokens = {"17", "5", "+"};
        assertThat(RPNCalculator.evaluate(tokens)).isEqualTo(22);
    }

    @Test
    public void should_evaluate_more_complex_addition() {
        String[] tokens = {"2", "3", "5", "+", "+"};
        assertThat(RPNCalculator.evaluate(tokens)).isEqualTo(10);
    }
    
        @Test
    public void should_evaluate_simple_substraction() {
            String[] tokens = {"17", "5", "-"};
        assertThat(RPNCalculator.evaluate(tokens)).isEqualTo(12);
    }

    @Test
    public void should_evaluate_more_complex_substraction() {
        String[] tokens = {"2", "3", "5", "-", "-"};
        assertThat(RPNCalculator.evaluate(tokens)).isEqualTo(4);
    }
    
            @Test
    public void should_evaluate_simple_mutliplication() {
        String[] tokens = {"17", "5", "*"};
        assertThat(RPNCalculator.evaluate(tokens)).isEqualTo(85);
    }

    @Test
    public void should_evaluate_more_complex_multiplication() {
        String[] tokens = {"2", "3", "5", "*", "*"};
        assertThat(RPNCalculator.evaluate(tokens)).isEqualTo(30);
    }
    
            @Test
    public void should_evaluate_simple_division() {
        String[] tokens = {"17", "5", "/"};
        assertThat(RPNCalculator.evaluate(tokens)).isEqualTo(3.4);
    }

    @Test
    public void should_evaluate_0_divided() {
        String[] tokens = {"2", "0", "/"};
        assertThat(RPNCalculator.evaluate(tokens)).isEqualTo(Double.POSITIVE_INFINITY);
    }
    
}

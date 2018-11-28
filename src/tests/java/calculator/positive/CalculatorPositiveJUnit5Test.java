package calculator.positive;

import calculator.Calculator;
import calculator.RPN;
import calculator.exceptions.InvalidExpressionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Calculator Positive Test Cases")
class CalculatorPositiveJUnit5Test {
    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void calculatorRunWithoutExceptionTest() {
        assertDoesNotThrow(() -> calculator.run("4+4"));
    }

    @Test
    void calculatorRunTest() {
        assertDoesNotThrow(() -> calculator.run("(100*100)*500+600-(3+5)*9/(2+(3+3))"));
    }

    @Test
    void calculateDivTest() throws InvalidExpressionException {
        double actual = calculator.calculate("4/4");
        double expected = 1;
        assertThat(actual, comparesEqualTo(expected));
    }

    @Test
    void calculateMulTest() throws InvalidExpressionException {
        double actual = calculator.calculate("100*100");
        double expected = 10000;
        assertThat(actual, comparesEqualTo(expected));
    }

    @Test
    void calculateSubTest() throws InvalidExpressionException {
        double actual = calculator.calculate("100+100+300");
        double expected = 500;
        assertThat(actual, comparesEqualTo(expected));
    }

    @Test
    void calculateWithBracketTest() throws InvalidExpressionException {
        double actual = calculator.calculate("(100*100)*500+600-(3+5)*9/(2+(3+3))");
        double expected = 5000591;
        assertThat(actual, comparesEqualTo(expected));
    }

    @Test
    void getRpnTest() throws InvalidExpressionException {
        RPN actual = calculator.getRpn("(100*100)*500+600-(3+5)*9/(2+(3+3))");
        assertThat(actual, notNullValue());
    }

    @AfterEach
    void tearDown() {

    }

}

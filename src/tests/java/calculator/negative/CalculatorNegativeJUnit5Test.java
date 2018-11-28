package calculator.negative;

import calculator.Calculator;
import calculator.exceptions.InvalidExpressionException;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Calculator Negative Test Cases")
class CalculatorNegativeJUnit5Test {
    Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @Test
    void calculatorRunWithStartBracketExceptionTest() {
        assertThrows(InvalidExpressionException.class, () -> calculator.run("(4+4"));
    }

    @Test
    void calculatorRunStartOperatorExceptionTest() {
        assertThrows(NoSuchElementException.class, () -> calculator.run("*4+4"));
    }

    @Test
    void calculatorRunWithEndBracketExceptionTest() {
        assertThrows(InvalidExpressionException.class, () -> calculator.run("4+4)"));
    }

    @Test
    void calculatorRunEndOperatorExceptionTest() {
        assertThrows(NoSuchElementException.class, () -> calculator.run("4+4*"));
    }

    @Test
    void calculateDivByZeroTest() throws InvalidExpressionException {
        double actual = calculator.calculate("4/0");
        double expected = Infinity;
        assertThat(actual, comparesEqualTo(expected));
    }

    @Test
    void calculateEmptyExpressionTest() {
        assertThrows(NullPointerException.class, () -> calculator.calculate(""));
    }

    @Test
    void calculateSymbolsExpressionTest() {
        assertThrows(NoSuchElementException.class, () -> calculator.calculate("a+b"));
    }

    @Test
    void calculateWrongOperatorExpressionTest() {
        assertThrows(NoSuchElementException.class, () -> calculator.calculate("45++36"));
    }


    @AfterEach
    void tearDown() {

    }

}

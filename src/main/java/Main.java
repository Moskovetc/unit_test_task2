import calculator.Calculator;
import calculator.exceptions.InvalidExpressionException;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.run();
        } catch (InvalidExpressionException e) {
            System.err.println("Неверное выражение!");
        }
    }
}

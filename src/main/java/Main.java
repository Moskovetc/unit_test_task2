import calculator.Calculator;
import calculator.exceptions.InvalidExpressionException;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            calculator.run("(100*100)*500+600-(3+5)*9/(2+(3+3))");
        } catch (InvalidExpressionException e) {
            System.err.println("Неверное выражение!");
        }
    }
}

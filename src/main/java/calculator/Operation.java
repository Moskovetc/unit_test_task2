package calculator;

public class Operation {

    public static <T extends Number> double plus(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number> double minus(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static <T extends Number> double mult(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number> double div(T a, T b) {
        return a.doubleValue() / b.doubleValue();
    }
}

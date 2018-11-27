package calculator.expression;

public class MyExpression {
    private String expression;

    public MyExpression(String expression) {
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    public void removeSpaces() {
        expression = expression.replaceAll("\\s+", "");
    }

    public boolean validate() {
        if (expression.replaceAll("\\(", "").length()
                != expression.replaceAll("\\)", "").length()) return false;
        if (expression.matches("^[\\*\\/]") | expression.matches("$[\\*\\/]")) return false;
        if (expression.matches("[a-zA-Z]]")) return false;
        return true;
    }
}

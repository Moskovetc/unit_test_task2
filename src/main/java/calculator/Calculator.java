package calculator;

import calculator.exceptions.InvalidExpressionException;
import calculator.expression.MyExpression;
import calculator.parser.LineParser;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Calculator {
//    public void run() throws InvalidExpressionException {
//        System.out.print("Claculator started!\n:");
//        Scanner scanner = new Scanner(System.in);
//        double result = calculate(scanner.nextLine());
//        System.out.println(">" + result);
//    }

    public void run(String expression) throws InvalidExpressionException {
        System.out.print(String.format("\nClaculator started!\n: %s", expression));
        double result = calculate(expression);
        System.out.println("\n>" + result);
    }

    public double calculate(String line) throws InvalidExpressionException {
        RPN rpn = getRpn(line);
        double result = 0;
        Deque<Double> tempStack = new ArrayDeque<>();
        List<String> postfixNotation = rpn.getPostFixNotation();
        for (String item : postfixNotation) {
            if (item.matches("-?\\d+"))
                tempStack.push(Double.valueOf(item));
            else {
                double secondOperand = tempStack.pop();
                double firstOperand = tempStack.pop();
                switch (item) {
                    case "+":
                        result = Operation.plus(firstOperand, secondOperand);
                        break;
                    case "-":
                        result = Operation.minus(firstOperand, secondOperand);
                        break;
                    case "*":
                        result = Operation.mult(firstOperand, secondOperand);
                        break;
                    case "/":
                        result = Operation.div(firstOperand, secondOperand);
                        break;
                }
                tempStack.push(result);
            }
        }
        return tempStack.peek();
    }

    public RPN getRpn(String line) throws InvalidExpressionException {
        MyExpression expression = new MyExpression(line);
        expression.removeSpaces();
        LineParser parser = new LineParser();
        if (expression.validate()) {
            parser.parse(expression.getExpression());
        } else throw new InvalidExpressionException();
        MyExpression simpleExpression = new MyExpression(parser.getSimpleExpression());
        simpleExpression.removeSpaces();
        return new RPN(parser.getNegativeOperands(), parser.getPositiveOperands(), simpleExpression.getExpression());
    }

}

package calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RPN {
    private List<String> negativeOperands;
    private List<String> positiveOperands;
    private String simpleExpression;

    public RPN(List<String> negativeOperands, List<String> positiveOperands, String simpleExpression) {
        this.negativeOperands = negativeOperands;
        this.positiveOperands = positiveOperands;
        this.simpleExpression = simpleExpression;
    }

    private int getPriority(char item) {
        if (item == '(') return 1;
        if (item == '+' || item == '-') return 2;
        if (item == '*' || item == '/') return 3;
        return 4;
    }

    public List<String> getPostFixNotation() {
        List<String> postFixNotation = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        int indexPositive = 0;
        int indexNegative = 0;
        for (char symbol : simpleExpression.toCharArray()) {
            if (symbol == 'p') {
                postFixNotation.add(positiveOperands.get(indexPositive));
                indexPositive++;
            } else if (symbol == 'n') {
                postFixNotation.add(negativeOperands.get(indexNegative));
                indexNegative++;
            } else {
                if (symbol == '(')
                    stack.push(symbol);
                else if (symbol == ')') {
                    char itemFromStack = stack.pop();
                    while (itemFromStack != '(') {
                        postFixNotation.add(String.valueOf(itemFromStack));
                        itemFromStack = stack.pop();
                    }
                } else {
                    if (!stack.isEmpty()) {
                        if (getPriority(symbol) <= getPriority(stack.peek()))
                            postFixNotation.add(String.valueOf(stack.pop()));
                    }
                    stack.push(symbol);
                }
            }
        }
        while (!stack.isEmpty())
            postFixNotation.add(String.valueOf(stack.pop()));
        return postFixNotation;
    }
}

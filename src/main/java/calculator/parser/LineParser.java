package calculator.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineParser {
    private List<String> negativeOperands;
    private List<String> positiveOperands;
    private String simpleExpression;

    public List<String> getNegativeOperands() {
        return negativeOperands;
    }

    public List<String> getPositiveOperands() {
        return positiveOperands;
    }

    public String getSimpleExpression() {
        return simpleExpression;
    }

    public void parse(String expression) {
        simpleExpression = expression;
        Pattern operand = Pattern.compile("[-\\(+\\/*]-\\d+");
        negativeOperands = new ArrayList<>();
        Matcher matcher = operand.matcher(simpleExpression);
        String item;
        while (matcher.find()) {
            item = matcher.group();
            negativeOperands.add(item.substring(1));
            simpleExpression = simpleExpression.replaceFirst("\\" + item, item.charAt(0) + "n ");
        }
        operand = Pattern.compile("^-\\d+");
        matcher = operand.matcher(simpleExpression);
        if (matcher.find()) {
            simpleExpression = simpleExpression.replaceFirst(matcher.group(0), "n");
            negativeOperands.add(0, matcher.group(0));
        }
        operand = Pattern.compile("\\d+");
        positiveOperands = new ArrayList<>();
        matcher = operand.matcher(simpleExpression);
        while (matcher.find()) {
            simpleExpression = simpleExpression.replaceFirst(matcher.group(), "p");
            positiveOperands.add(matcher.group());
        }

    }

}

package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final int MIN = 0;
    private static final int MAX = 50;
    private static final char[] OPERATIONS = new char[]{'+', '-', '*'};

    public static void start() {
        String[][] data = new String[Engine.COUNT_OF_ATTEMPTS][Engine.COUNT_OF_DATA];
        for (int i = 0; i < data.length; i++) {
            int operand1 = Utils.getRandomNumber(MIN, MAX);
            int operand2 = Utils.getRandomNumber(MIN, MAX);
            char operation = OPERATIONS[Utils.getRandomNumber(0, OPERATIONS.length)];
            String result = getCalculationResult(operation, operand1, operand2);
            data[i][0] = operand1 + " " + operation + " " + operand2;
            data[i][1] = result;
        }
        String rule = "What is the result of the expression?";
        Engine.review(data, rule);
    }

    private static String getCalculationResult(char operation, int operand1, int operand2) {
        return switch (operation) {
            case '-' -> Integer.toString(operand1 - operand2);
            case '+' -> Integer.toString(operand1 + operand2);
            case '*' -> Integer.toString(operand1 * operand2);
            default -> throw new RuntimeException("Operation is not supported.");
        };
    }
}

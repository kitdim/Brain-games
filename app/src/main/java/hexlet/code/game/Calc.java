package hexlet.code.game;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public final class Calc {
    private static final byte LENGTH_OPERATIONS = 3;
    private static final byte COUNT_OF_ATTEMPTS = 3;
    private static char operation;
    private static int operand1;
    private static int operand2;

    public static void start() {
        String userName = Cli.getUserName();
        Cli.hello(userName);
        char[] operations = new char[]{'+', '-', '*'};
        System.out.println("What is the result of the expression?");
        for (int i = COUNT_OF_ATTEMPTS; i > 0; i--) {
            operand1 = Utils.getRandomNumber();
            operand2 = Utils.getRandomNumber();
            operation = operations[Utils.getRandomNumber(LENGTH_OPERATIONS)];
            int result = calculation();
            String answer = Engine.buildGame(operand1, operand2, operation, result);
            if (answer.equals("yes")) {
                Engine.showAnswer();
            } else {
                Engine.showAnswer(result);
                break;
            }
        }
        Engine.showResult(userName);
    }

    public static int calculation() {
        switch (operation) {
            case '+' -> {
                return operand1 + operand2;
            }
            case '-' -> {
                return operand1 - operand2;
            }
            case '*' -> {
                return operand1 * operand2;
            }
            default -> {
            }
        }
        return 0;
    }
}

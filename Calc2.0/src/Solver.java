import java.text.ParseException;
import java.util.Arrays;

public class Solver implements Calc {

    private final InputParser inputParser;

    public Solver() {
        inputParser = new InputParser();
    }

    private char[] getChar(int i){
        char[] chars = new char[2];
        switch (i){
            case 0:
                chars[0] = '^';
                chars[1] = '^';
                break;
            case 1:
                chars[0] = '*';
                chars[1] = '/';
                break;
            case 2:
                chars[0] = '+';
                chars[1] = '-';
                break;
        }
        return chars;
    }

    @Override
    public double calculate(String exp) throws ParseException {
        //for (int i = InputParser.OPERATIONS.length - 1; i >= 0 ; i--) {
        for (int i = 0; i < 3; i++) {
            boolean find = true;
            do {
                char[] chars = getChar(i);
                System.out.println("Seach " + Arrays.toString(chars) + " in");
                System.out.println(exp);
                ExpressionEx expressionEx = inputParser.findExp(exp, chars[0], chars[1]);
                find = expressionEx.find;
                if (!expressionEx.isValid()) {
                    throw new ArithmeticException();
                }
                if (!find) {
                    break;
                }
                double res = calculate(expressionEx);
                exp = inputParser.replace(exp, expressionEx);
            } while (find);
        }
        return Double.valueOf(exp);
    }

    @Override
    public double calculate(Expression exp) {
        SimpleSolver simpleSolver = new SimpleSolver();
        return simpleSolver.calculate(exp);
    }
}

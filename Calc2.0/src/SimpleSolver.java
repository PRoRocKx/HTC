import java.text.ParseException;

public class SimpleSolver implements Calc {
    private final InputParser inputParser;

    public SimpleSolver() {
        inputParser = new InputParser();
    }

    public double calculate(Expression expression){
        switch (expression.getAction()){
            case DIFF: expression.setResult(expression.getA() - expression.getB());
                break;
            case SUM: expression.setResult(expression.getA() + expression.getB());
                break;
            case MULT: expression.setResult(expression.getA() * expression.getB());
                break;
            case QUOT: expression.setResult(expression.getA() / expression.getB());
                break;
            case EXP: expression.setResult(Math.pow(expression.getA(), expression.getB()));
                break;
        }
        return expression.getResult();
    }

    @Override
    public double calculate(String exp) throws ParseException {
        Expression expression = inputParser.parse(exp);
        calculate(expression);
        if (expression.isValid()) {
            return (expression.getResult());
        } else {
            throw new ArithmeticException();
        }
    }
}

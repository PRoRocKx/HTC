import java.text.ParseException;

public class Calc {

    protected final InputParser inputParser;

    public Calc() {
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

    public String calculate(String exp){
        Expression expression = null;
        try {
            expression = inputParser.parse(exp);
        } catch (ParseException e) {
            return exp + " " + e.getLocalizedMessage();
        }
        calculate(expression);
        if (expression.isValid()){
            int intResult = (int)expression.getResult();
            return expression.getResult() == intResult ? String.valueOf(intResult) : String.valueOf(expression.getResult());
        } else{
            if (expression.getError() != null && !expression.getError().isEmpty()) {
                return expression.getError();
            } else {
                return exp + " is not an expression";
            }
        }
    }

}

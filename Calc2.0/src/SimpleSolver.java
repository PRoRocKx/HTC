public class SimpleSolver implements Calc {

    public double calculate(Expression expression){
        switch (expression.action){
            case 0: expression.result = (expression.a - expression.b);
                break;
            case 1: expression.result = (expression.a + expression.b);
                break;
            case 2: expression.result = (expression.a * expression.b);
                break;
            case 3: expression.result = (expression.a / expression.b);
                break;
            case 4: expression.result = (Math.pow(expression.a, expression.b));
                break;
            default:
                expression.valid = false;
        }
        return expression.result;
    }

    @Override
    public double calculate(String exp) {
        InputParser inputParser = new InputParser();
        Expression expression = inputParser.parse(exp);
        calculate(expression);
        if (expression.valid)
            return (expression.result);
        else
            throw new ArithmeticException();
    }
}

public class Calc {

    private void calculate(Expression expression){
        switch (expression.action){
            case 0: expression.result = (expression.a + expression.b);
                break;
            case 1: expression.result = (expression.a - expression.b);
                break;
            case 2: expression.result = (expression.a * expression.b);
                break;
            case 3:
                try {
                    expression.result = (expression.a / expression.b);
                } catch (ArithmeticException e){
                    expression.valid = false;
                    expression.error = "/ by zero";
                }
                break;
            case 4: expression.result = (Math.pow(expression.a, expression.b));
                break;
            default:
                expression.valid = false;
        }
    }

    public String calculate(String exp){
        InputParser inputParser = new InputParser();
        Expression expression = inputParser.parse(exp);
        calculate(expression);
        if (expression.valid){
            int intResult = (int)expression.result;
            return expression.result == intResult ? String.valueOf(intResult) : String.valueOf(expression.result);
        }
        else{
            if (expression.error != null && !expression.error.isEmpty())
                return expression.error;
            else
                return "error";
        }
    }

}

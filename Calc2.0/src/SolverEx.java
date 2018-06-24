import java.text.ParseException;

public class SolverEx implements Calc {

    private final Calc simpleSolver;
    private final InputParser inputParser;
    private final Calc calc;

    SolverEx() {
        simpleSolver = new SimpleSolver();
        inputParser = new InputParser();
        calc = new Solver();
    }

    @Override
    public double calculate(String exp) throws ParseException {
        boolean stop = false;
        do {
            String tempExp = inputParser.findBrackets(exp);
            if (tempExp != null) {
                //Calc calc = new Solver();
                exp = inputParser.replace(exp, tempExp, calc.calculate(tempExp.substring(1, tempExp.length() - 1)));
            } else {
                stop = true;
            }
        } while (!stop);
        return calc.calculate(exp);
    }

    @Override
    public double calculate(Expression exp) {
        return simpleSolver.calculate(exp);
    }
}

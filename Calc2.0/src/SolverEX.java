import java.text.ParseException;

public class SolverEX implements Calc{

    private final Calc simpleSolver;
    private final InputParser inputParser;

    SolverEX() {
        simpleSolver = new SimpleSolver();
        inputParser = new InputParser();
    }

    @Override
    public double calculate(String exp) throws ParseException {
        boolean stop = false;
        do {
            String tempExp = inputParser.findBrackets(exp);
            if (tempExp != null) {
                Calc calc = new Solver();
                exp = inputParser.replace(exp, tempExp, calc.calculate(tempExp.substring(1,tempExp.length() - 1)));
            }
            else {
                stop = true;
            }
        }while (!stop);
        Calc calc = new Solver();
        return calc.calculate(exp);
    }

    @Override
    public double calculate(Expression exp) {
        return simpleSolver.calculate(exp);
    }
}

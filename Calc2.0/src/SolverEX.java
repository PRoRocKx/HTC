public class SolverEX implements Calc{

    @Override
    public double calculate(String exp) {
        InputParser inputParser = new InputParser();
        boolean stop = false;
        do {
            String tempExp = inputParser.findBrackets(exp);
            if (tempExp != null) {
                Calc calc = new Solver();
                exp = inputParser.replace(exp, tempExp, calc.calculate(tempExp.substring(1,tempExp.length() - 1)));
            }
            else
                stop = true;
        }while (!stop);
        Calc calc = new Solver();
        return calc.calculate(exp);
    }

    @Override
    public double calculate(Expression exp) {
        Calc simpleSolver = new SimpleSolver();
        return simpleSolver.calculate(exp);
    }
}

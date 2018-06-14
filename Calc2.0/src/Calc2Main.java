public class Calc2Main {

    public static void main(String... arg) {
        Calc calc = new SolverEX();
        FileIO fileIO = new FileIO();
        String exp = fileIO.read();
        if (exp != null){
            fileIO.write(calc.calculate(exp));
        }
    }
}

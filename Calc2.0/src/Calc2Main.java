import java.text.ParseException;

public class Calc2Main {

    public static void main(String... arg) {
        Calc calc = new SolverEx();
        FileIO fileIO = new FileIO();
        String exp = fileIO.read();
        if (exp != null) {
            try {
                fileIO.write(calc.calculate(exp));
            } catch (ParseException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
    }
}

import java.text.ParseException;

public interface Calc {
    public double calculate(String exp) throws ParseException;

    public double calculate(Expression exp);
}

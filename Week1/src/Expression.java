import java.text.ParseException;

public class Expression {

    public enum Action {DIFF, SUM, MULT, QUOT, EXP};

    public static Action getAct(char c) throws ParseException {
        switch (c){
            case '-': return Action.DIFF;
            case '+': return Action.SUM;
            case '*': return Action.MULT;
            case '/': return Action.QUOT;
            case '^': return Action.EXP;
            default: throw new ParseException("unknown operator " + c, 0);
        }
    };

    private double a;
    private double b;
    private Action action;
    private boolean valid;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    private String error;
    private double result;

    public Expression(double a,double b, Action action){
        this.a = a;
        this.b = b;
        this.action = action;
        valid = true;
    }

    public Expression(boolean valid){
        this.valid = valid;
    }

    public Expression(boolean valid, String error){
        this.valid = valid;
        this.error = error;
    }

    public Expression() {
    }
}

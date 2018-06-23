public class ExpressionEx extends Expression {
    int startChar;
    int endChar;
    boolean find = false;

    public ExpressionEx(double a, double b, Action action, int startChar, int endChar) {
        super(a, b, action);
        this.startChar = startChar;
        this.endChar = endChar;
        find = true;
    }

    public ExpressionEx(boolean valid, boolean find) {
        super(valid);
        this.find = find;
    }
    public ExpressionEx(boolean valid) {
        super(valid);
    }


}

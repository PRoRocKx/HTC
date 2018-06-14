public class Expression {

    double a;
    double b;
    int action;
    boolean valid;
    String error;
    double result;

    public Expression(double a,double b, int action){
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

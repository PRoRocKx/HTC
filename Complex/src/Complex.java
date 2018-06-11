public class Complex {

    double real;
    double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(){}

    public Complex fromTrigonometric(double module, double fi) {
        return new Complex(module * Math.cos(fi), module * Math.sin(fi));
    }

    public double getFi() {
        if (real == 0 && imaginary == 0)
            throw new ArithmeticException();
        if (real > 0) {
            return Math.atan(imaginary / real);
        } else {
            if (imaginary > 0) {
                return Math.atan(imaginary / real) + Math.PI;
            } else {
                return Math.atan(imaginary / real) - Math.PI;
            }
        }
    }

    public double getModule(){
        return Math.sqrt(Math.pow(real,2) + Math.pow(imaginary,2));
    }

    public String toTrigonometric(){
        return getModule() + "(cos" + getFi() + " + sin" + getFi() + ")";
    }

    public String toExponential(){
        return getModule() + " * e^(i * " + getFi() + ")";
    }

    public Complex add(Complex complex){
        return new Complex(complex.real + real, imaginary + complex.imaginary);
    }

    public Complex sub(Complex complex){
        return new Complex(real - complex.real, imaginary - complex.imaginary);
    }

    public Complex multiply(Complex complex){
        return new Complex(real*complex.real - imaginary*complex.imaginary, real*complex.imaginary + complex.real*imaginary);
    }

    public Complex div(Complex complex){
        double divider = Math.pow(complex.real,2) + Math.pow(complex.imaginary,2);
        if (divider == 0)
            throw new ArithmeticException();
        return new Complex((real*complex.real + imaginary*complex.imaginary)/divider, (imaginary*complex.real - real*complex.imaginary)/divider);
    }

    public Complex pow(int pow){
        double module = Math.pow(getModule(),pow);
        double fi = getFi() * pow;
        return new Complex().fromTrigonometric(module,fi);
    }

    @Override
    public String toString() {
        return real + " + i" + imaginary;
    }
}

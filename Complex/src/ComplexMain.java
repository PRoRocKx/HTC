public class ComplexMain {
    public static void main(String... arg){
        Complex complex = new Complex(1,1);
        System.out.println(complex.toString());
        System.out.println(complex.toExponential());
        System.out.println(complex.toTrigonometric());
    }
}

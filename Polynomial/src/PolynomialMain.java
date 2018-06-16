import java.util.HashMap;
import java.util.Map;

public class PolynomialMain {
    public static void main(String... args){
        Map<String,Integer> polynomial = new HashMap<>();
        Map<String,Integer> polynomial2 = new HashMap<>();
        polynomial.put("X^2",5);
        polynomial.put("XY",1);
        polynomial.put("Y^2",3);
        polynomial.put("X^2Y",7);
        polynomial.put("XY^2",9);
        polynomial.put("X",7);
        polynomial.put("Y",9);

        polynomial2.put("X^2",1);
        polynomial2.put("XY",2);
        polynomial2.put("X^2Y",4);
        polynomial2.put("XY^2",2);
        polynomial2.put("X",4);
        System.out.println(polynomial);
        System.out.println(polynomial2);
        Map<String,Integer> res = new HashMap<>(polynomial);
        for (Map.Entry<String,Integer> entry: polynomial2.entrySet()) {
            if(res.containsKey(entry.getKey())){
                res.put(entry.getKey(), entry.getValue() + res.get(entry.getKey()));
            }
            else{
                res.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println(res);

    }
}

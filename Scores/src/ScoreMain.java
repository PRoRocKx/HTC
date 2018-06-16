import java.util.HashSet;
import java.util.Set;

public class ScoreMain {
    public static void main(String... args){
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            hashSet.add(i);
        }
        Set<Integer> hashSet2 = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            hashSet2.add(i + 5);
        }
        Scores<Integer> scores = new Scores<>();
        System.out.println("set 1");
        System.out.println(hashSet.toString());
        System.out.println("set 2");
        System.out.println(hashSet2.toString());
        System.out.println("union");
        System.out.println(scores.union(hashSet,hashSet2));
        System.out.println("retain");
        System.out.println(scores.retain(hashSet,hashSet2));
        System.out.println("complement");
        System.out.println(scores.complement(hashSet,hashSet2));
    }
}

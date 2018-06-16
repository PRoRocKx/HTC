import java.util.HashSet;
import java.util.Set;

public class Scores<E> {

    public Set<E> union(Set<E> set1, Set<E> set2){
        Set<E> set = new HashSet<>(set1);
        set.addAll(set2);
        return set;
    }

    public Set<E> retain(Set<E> set1, Set<E> set2){
        Set<E> set = new HashSet<>(set1);
        set.retainAll(set2);
        return set;
    }

    public Set<E> complement(Set<E> set1, Set<E> set2){
        Set<E> set = new HashSet<>(set1);
        set.removeAll(set2);
        return set;
    }
}

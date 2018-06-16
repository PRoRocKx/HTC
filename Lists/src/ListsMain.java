import java.util.*;

public class ListsMain {
    public static void main(String... args){
        List<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 51; i++) {
            list.add(random.nextInt(100) - 50);
        }
        LinkedList<Integer> list2 = new LinkedList<>(list);
        System.out.println(list);
        //way 1
        list.sort((o1, o2) -> o1 < o2 ? 1 : (o1.equals(o2) ? 0 : -1));
        System.out.println(list);
        //way 2
        int n = 0;
        int end = list2.size();
        while (n < end){
            if (list2.get(n) < 0) {
                list2.addLast(list2.get(n));
                list2.remove(n);
                end--;
            }
            else
                n++;
        }
        System.out.println(list2);
    }
}

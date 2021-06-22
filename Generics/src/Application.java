import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Application {
    public static void main(String args[]){
        MyGenericClass<Integer,String> myGeneric = new MyGenericClass<>(100,"Ram");
        Set<Integer> set1 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        Set<Integer> set2 = new HashSet<>();

        set2.add(5);
        set2.add(4);
        set2.add(7);
        set2.add(7);
        Set<Integer> result = union(set1,set2);

        Iterator<Integer> itr = result.iterator();
        while (itr.hasNext()) System.out.println(itr.next());

        int i = myGeneric.getItem1();
//        System.out.println(myGeneric.getItem1());
//        System.out.println(myGeneric.getItem2());


    }
    // Generic Method

    public static <E> Set<E> union(Set<E> set1,Set<E> set2){
        Set<E> result = new HashSet<>(set1);
        result.addAll(set2);

        return result;
    }
}

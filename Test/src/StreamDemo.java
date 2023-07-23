import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        List<Integer> ar = Arrays.asList(15,10,12,11,1,2,3,4,5,6,7,8,9);

        Optional<Integer> arrsum = ar.stream().reduce((a,sum)->a+sum);
        long count = ar.stream().limit(3).count();
        System.out.println(arrsum.get());
        System.out.println(count);

        Optional<Integer> max = ar.stream().max((a,b)->a.compareTo(b));
        System.out.println(max.get());

        Optional<Integer> min = ar.stream().min((a,b)->a.compareTo(b));
        System.out.println(min.get());

        ar.stream().forEach(System.out::print);
        List<Integer> even = ar.stream().filter(n->n%2==0&&n>2).sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println(even);

        Map<Integer,String> mp = new HashMap<>();

        mp.put(1,"Ashish");
        mp.put(2,"Arvind");
        mp.put(3,"Abhishek");
        mp.put(4,"Kishore");
        mp.put(5,"Manish");

        mp.entrySet().stream().filter(a->a.getKey()%2==0);
        Set<Map.Entry<Integer,String>> s = mp.entrySet().stream().filter(a->a.getKey()%2==0).collect(Collectors.toSet());
        s.forEach(a-> System.out.println(a.getKey()+" "+a.getValue()));


    }
}

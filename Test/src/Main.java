import java.util.*;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

class Student{

    int rollNo;
    String name;
    String address;

}

public class Main {

    synchronized static int fibonacci()
    {
        return 0;
    }

    public static void main(String[] args) {

        Set<Double> s = new HashSet<>();

        Map<Integer,String> mp = new HashMap<>();
        mp.put(1,"Ashish");
        mp.put(2,"Arvind");

//        Set<Map.Entry<Integer,Student>> me = mp.entrySet();

        Stream.of(mp.entrySet()).forEach(entry->
            entry.forEach(e-> System.out.println(e.getKey()+" "+e.getValue()))
        );

        Stream.of(mp.entrySet().toArray()).forEach(e-> System.out.println(e));

        mp.entrySet().forEach(e-> System.out.println(e.getKey()));

        Double[] in = new Double[1000000];

        for(int i=0;i<1000000;i++)
        {
            in[i] = Math.random();
        }

        ArrayList<Double> a = new ArrayList<>();
        LinkedList<Double> l = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();

        s.addAll(Arrays.asList(in));
//        System.out.println(s.size());
//        s.retainAll(Arrays.asList(in));
        System.out.println(s.containsAll(Arrays.asList(in)));

        System.out.println("ArrayList adding");
        System.out.println(System.currentTimeMillis());
        a.addAll(Arrays.asList(in));
        System.out.println(System.currentTimeMillis());
        System.out.println();

        System.out.println("LinkedList adding");
        System.out.println(System.currentTimeMillis());
        l.addAll(Arrays.asList(in));
        System.out.println(System.currentTimeMillis());
        System.out.println();

        System.out.println("ArrayList inserting");
        System.out.println(System.currentTimeMillis());
        a.add(10,100.00);
        System.out.println(System.currentTimeMillis());
        System.out.println();

        System.out.println("LinkedList inserting");
        System.out.println(System.currentTimeMillis());
        l.add(10,100.00);
        System.out.println(System.currentTimeMillis());
        System.out.println();

        System.out.println("ArrayList finding index");
        System.out.println(System.currentTimeMillis());
        a.get(103450);
        System.out.println(System.currentTimeMillis());
        System.out.println();

        System.out.println("LinkedList finding index");
        System.out.println(System.currentTimeMillis());
        l.get(103450);
        System.out.println(System.currentTimeMillis());
        System.out.println();

//        (x)-> {
//            return x + x;
//        };

//        Map<Integer,String> m = new HashMap<>();
//        m.put(1,"Arvind");
//        m.put(2,"Ashish");
//        m.put(3,"Abhishek");
//        m.put(4,"Manish");
//        m.put(5,"Kishore");
//
//        System.out.println(m.replace(5, null));
//        System.out.println(m.getOrDefault(2,"not present"));
//
//        m.forEach((a, b)->{
//            System.out.println(a+" "+b);});
//
        }
}
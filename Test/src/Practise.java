import java.util.*;

interface Cab {
    public void bookCab(String source,String dest);

}

public class Practise {

    public static void main(String[] args) {

        Map<Integer,String> tm = new TreeMap<>();

        tm.put(1,"Ashish");
        tm.put(2,"Arvind");
        tm.put(3,"Kishore");
        tm.put(4,"Abhishek");

        Set<Integer> ts = new HashSet<>();

        ts.add(null);
        ts.add(5);
        ts.add(2);
        ts.add(4);

        ts.forEach((value)-> System.out.println(value));

        int a = 10;

        Cab c = ((source, dest) -> System.out.println(source+"->"+dest));
        c.bookCab("Raipur","Bangalore");
    }
}

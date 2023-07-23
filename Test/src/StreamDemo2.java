import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamDemo2 {

    public static void main(String[] args) {

        List<Integer> li = Arrays.asList(1,2,3,4,5,6);
        List<String> ls = Arrays.asList("Hello","hi","Bye");

        Stream<Integer> si = li.stream();
        Stream<String> ss = ls.stream();

//        Stream.concat(si,ss).forEach(e-> System.out.println(e));  // Stream Concatenation

//        Integer i = si.reduce(0,Integer::sum);
//        System.out.println(i);

//        String str = ss.reduce("1",String::concat);
//        Optional<String> str1 = ss.reduce((s, sum)->s+sum);
//        System.out.println(str1.get());

//        System.out.println(ss.anyMatch(s->s.contains("m")));
//        System.out.println(ss.anyMatch(s->s.startsWith("h")));

//        System.out.println(si.allMatch(k->k.equals(5)));
//        System.out.println(si.noneMatch(k->k.equals(5)));

        List<List<String>> list = new ArrayList<>();
        List<String> s1 = Arrays.asList("hi","hello","greetings");
        List<String> s2 = Arrays.asList("bye","see you","goodbye");

        list.addAll(Arrays.asList(s1,s2));

//        list.stream().flatMap(e->e.stream()).filter(s->s.length()<=2).forEach(s-> System.out.println(s));
        list.stream().flatMap(e->e.stream()).map(s->s+"1").forEach(f-> System.out.println(f));

        Integer[][] arr = {{1,2},{3,4},{5,6},{7,8},{9,10}};

        Arrays.stream(arr).flatMap(i-> Arrays.stream(i)).forEach(s-> System.out.println(s));

        Arrays.stream(arr).forEach(e-> Arrays.stream(e).forEach(a-> System.out.print(a+" ")));

    }
}

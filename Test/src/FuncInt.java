import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FuncInt {

    public static void main(String[] args) {

//        Runnable a = ()->{while(true)System.out.println("Hello");};
//
//        Runnable b = ()->{while(true)System.out.println("Hi");};
//
//        new Thread(a).start();
//        new Thread(b).start();

        Predicate<Integer> p1 = i->i<50;
        Predicate<Integer> p2 = i->i>10;
        System.out.println(p1.and(p2).test(0));

        Function<Integer,Integer> f = i->i*i;
        System.out.println(f.apply(10));

        Consumer<String> c = s-> System.out.println(s);
        c.accept("Hello");

        Supplier<Date> s = ()->new Date();
        System.out.println(s.get());
    }
}

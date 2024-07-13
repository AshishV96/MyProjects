import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Scanner;

abstract class Calculator {
    abstract int add(int a, int b);
}

class Adder extends Calculator {
    @Override
    int add(int a, int b) {
        System.out.println("Adding integers: " + a + " " + b);
        return a + b;
    }
}

class Multiplier {
    int multiply(int a, int b, Calculator calculator) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result = calculator.add(result, a);
        }
        return result;
    }
}

class MyObject {

    int id;
    Boolean valid;

}
public class Solution {

    public static void main(String[] args) {

        int a = 1;
        System.out.println(a);

        int n = 306;
        String s = "";

        long expireTime = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusDays(3)).toHours();

        Calendar c = Calendar.getInstance();
        c.set(2020,12,12);

        while(n>0)
        {
            int q = n%10;
            s = q + s;
            n = n/10;
        }
        if (n == Integer.parseInt(s)) {
            System.out.println("Good job");
        } else {
            System.out.println("Wrong answer.");
        }
//        Scanner sc = new Scanner(System.in);
//        String in = "";
//        String multi = "";
//        while(sc.hasNextLine())
//        {
//            in = sc.nextLine();
//
//            if(in.contains("//"))
//                System.out.println(in.substring(in.indexOf("//")).trim());
//
//            if(in.contains("/*")&&in.contains("*/"))
//                System.out.println(in.substring(in.indexOf("/*"),in.lastIndexOf("/")+1).trim());
//            else if(in.contains("/*")&&!in.contains("*/"))
//            {
//                multi = in.substring(in.indexOf("/*"))+"\n";
//                in = sc.nextLine();
//                while(!in.contains("*/"))
//                {
//                    multi += in+"\n";
//                    in = sc.nextLine();
//                }
//                multi += in.substring(0,in.lastIndexOf("/")+1);
//                System.out.println(multi.trim());
//            }
//        }

    }
}

//public class Solution {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Testing Addition");
//        int num1 = scanner.nextInt();
//        int num2 = scanner.nextInt();
//
//        Adder adder = new Adder();
//        int sum = adder.add(num1, num2);
//        System.out.println("Sum = " + sum);
//
//        System.out.println("Testing Multiplication, Product =");
//        int num3 = scanner.nextInt();
//        int num4 = scanner.nextInt();
//
//        Multiplier multiplier = new Multiplier();
//        int product = multiplier.multiply(num3, num4, adder);
//
//        System.out.println("Product = " + product);
//
//        scanner.close();
//    }
//}
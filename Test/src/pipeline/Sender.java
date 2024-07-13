package pipeline;

abstract class Animal{
    public abstract void noice();
}
public class Sender extends Animal{
    @Override
    public void noice() {
//        super.noice();
        System.out.println("hi");
    }

    public static void main(String[] args) {
        // Call a method
//        myMethod();
        call();
    }

    static void call()
    {
        myMethod();
    }

    static void myMethod() {
        // Get the current stack trace
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // The calling method name is at index 2 (index 0 and 1 are for getStackTrace and myMethod)
        String callingMethodName = stackTrace[2].getMethodName();

        System.out.println("Calling method name: " + callingMethodName);

        System.out.println(5 + 7 + "8");
    }
}

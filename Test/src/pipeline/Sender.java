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

    }
}

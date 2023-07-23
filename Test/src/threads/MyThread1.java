package threads;

public class MyThread1 extends Thread{

    @Override
    public void run() {
        while(true)
            System.out.println("hi");
    }

    public void print(){
        System.out.println("printer running");
    }

    public static void main(String[] args) throws InterruptedException {

        MyThread1 t1 = new MyThread1();
        t1.setName("MyThread1");


        while(true) {
            System.out.println("hello");
            Thread.sleep(1000);
        }
    }
}

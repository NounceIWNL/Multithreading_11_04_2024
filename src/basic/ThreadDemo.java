package basic;

public class ThreadDemo extends Thread {
    public static void main(String[] args) {
        System.out.println("Thread : " + Thread.currentThread().getName());
        System.out.println("Creating a child thread");
        Thread thread = new ThreadDemo();
    }
}

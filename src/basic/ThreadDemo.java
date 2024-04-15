package basic;

public class ThreadDemo extends Thread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread : " + Thread.currentThread().getName());
        System.out.println("Creating a child thread");
        Thread thread = new ThreadDemo();
        System.out.println("Child is starting");
        thread.start();

        thread.join();

        System.out.println("Finish: " + Thread.currentThread().getName());
    }

    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.println("Thread: " + i);

        }
        System.out.println("Finish: " + Thread.currentThread().getName());
    }
}

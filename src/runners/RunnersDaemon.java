package runners;

public class RunnersDaemon {
    public static void main(String[] args) throws InterruptedException {
        //Создать бегунов, каждый со своими часами
        Runner runner1 = new Runner();
        Runner runner2 = new Runner();
        //Поместить бегунов на беговые дорожки
        Thread thread1 = new Thread(runner1);
        thread1.setDaemon(true);
        Thread thread2 = new Thread(runner2);
        thread2.setDaemon(true);
        //Старт
        thread1.start();
        thread2.start();
        Thread.sleep(5000); //Закомментировать
    }

    static class Runner implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while (true) {
                System.out.printf("Runner %s is running, step: %d%n", Thread.currentThread().getName(), i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 
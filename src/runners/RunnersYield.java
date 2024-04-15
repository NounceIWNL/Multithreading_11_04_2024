package runners;

public class RunnersYield {
    public static void main(String[] args) {
        Runner runner1 = new Runner("1", 1);
        Runner runner2 = new Runner("2", 1);
        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();

    }

    static class Runner implements Runnable {
        private String name;
        private int speed;

        public Runner(String name, int speed) {

            this.name
                    = name;
            this.speed = speed;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                if (name.equals("1")) Thread.yield(); //
                System.out.printf("Runner %s is running, step: %d%n", name, i);
                try {
                    Thread.sleep(1000 / speed);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
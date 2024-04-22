package runners;

public class RunnersClock {
    public static void main(String[] args) {
        Runner runner1 = new Runner(1);
        Runner runner2 = new Runner(2);
        Runner runner3 = new Runner(3);
        //
        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        Thread thread3 = new Thread(runner3);
        //
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Runner implements Runnable {
        private int index;

        public Runner(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            long finish = start + 3 * 100;
            int i = 0;
            while (System.currentTimeMillis() < finish) {
                i++;
                System.out.println("Runner " + index + " is running, step " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
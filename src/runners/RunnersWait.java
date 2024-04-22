package runners;

public class RunnersWait {
    public static void main(String[] args) throws InterruptedException {
        Runner runner1 = new Runner();
        runner1.start();

//        runner1.runProcess();
        Thread.sleep(500);

        runner1.stopProcess();
        Thread.sleep(3000);

        runner1.resumeProcess();
        Thread.sleep(500);

        runner1.interrupt();

    }

    static class Runner extends Thread {
        private Object mutex = new Object(); //Mutex
        private volatile boolean paused = false; //


        @Override
        public void run() {
            int i = 0;

            while (!isInterrupted()) {
                System.out.println("Runner is running, step " + i++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Runner finished");
                    return;
                }
            }
        }

        public void resumeProcess() {
            synchronized (mutex) {
                if (paused) {
                    mutex.notifyAll();
                    paused = false;
                }
            }
        }

        public void stopProcess() {
            paused = true;
        }
        public void runProcess() {
            paused = false;
        }
    }
}
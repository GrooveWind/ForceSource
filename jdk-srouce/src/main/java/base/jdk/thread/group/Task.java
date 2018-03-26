package base.jdk.thread.group;

import java.util.Random;

public class Task implements Runnable {
    @Override
    public void run() {
        int result = 0;
        Random random = new Random(Thread.currentThread().getId());

        while (true) {
            result = 1000 / ((int) random.nextDouble() * 1000);
            System.out.printf("%s : %f\n",Thread.currentThread().getId(),result);
            // Check if the Thread has been interrupted
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n",Thread.currentThread().getId());
                return;
            }
        }
    }

    public static void main(String[] args) {
        MyThreadGroup myThreadGroup = new MyThreadGroup("BOOGALOO");
        Task task = new Task();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(myThreadGroup, task);
            thread.start();
        }
    }
}

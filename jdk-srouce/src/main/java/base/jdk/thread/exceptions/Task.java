package base.jdk.thread.exceptions;

public class Task implements Runnable {

    @Override
    public void run() {
        int num = Integer.parseInt("acr368");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }

}

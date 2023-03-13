public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }
    public void run() {
        System.out.println(
                String.format("The thread %s is started", getName())
        );
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(
                String.format("The thread %s is ended", getName())
        );
    }
}

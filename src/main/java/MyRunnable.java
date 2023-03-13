class MyRunnable implements Runnable {
    private String name;
    public MyRunnable(String name) {
        this.name = name;
    }
    public void run(){
        System.out.println(
                String.format("The thread %s is started", this.name)
        );
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(
                String.format("The thread %s is ended", this.name)
        );
    }
} 
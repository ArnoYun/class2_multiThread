public class FindSum extends Thread {

    private int[] array;
    int start;
    int end;

    public FindSum(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public long sum;

    public void run() {

        System.out.println(String.format("Thread started in range: %d:%d", start, end));
        for (int i = start; i <= end; i++) {
            if(i < array.length)
            sum = sum + array[i];
        }
        System.out.println(sum);
    }
}

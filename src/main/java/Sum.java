import java.util.Random;

public class Sum {
    public static void main(String[] args) throws InterruptedException {

        Random rn = new Random();
        int n = 50;
        int[] array = new int[n+1];

        for (int i = 0; i <= n; i++) {
            array[i] = i+2;
            System.out.println(array[i]);
        }



        final int numberOfThreads = 4;

//        int numberOfElementsInThread = array.length / numberOfThreads;
        int numberOfElementsInThread = (int)Math.ceil((double)(n) / (double)(numberOfThreads));
        System.out.println(numberOfElementsInThread);
        FindSum[] threads = new FindSum[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {

            int start = i * numberOfElementsInThread;
            int end = (i + 1) * numberOfElementsInThread-1;

            threads[i] = new FindSum(array, start, end);
            threads[i].start();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }

        long sum = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            sum = sum + threads[i].sum;
        }

        System.out.println("Sum: "+sum);


    }
}

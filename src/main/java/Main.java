import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n, чтобы найти количество простых чисел от 1 до n:");
        int n = scanner.nextInt();

        long startTime = System.currentTimeMillis();
        final int numberOfThreads = 4;

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = i+1;
        }



        int numberOfElementsInThread = array.length / numberOfThreads;
        FindSimpleNumAmount[] threads = new FindSimpleNumAmount[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * numberOfElementsInThread+1;
            int end = (i+1) * numberOfElementsInThread;
            if (end > array.length-1) {
                end = array.length-1;
            }

            System.out.println(array[start]+"  "+array[end]);
            threads[i] = new FindSimpleNumAmount(array, start, end);
            threads[i].start();
        }


        for (int i = 0; i < numberOfThreads; i++) {
            threads[i].join();
        }

        int counter = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            counter = counter + threads[i].counter;
        }

        System.out.println(String.format("Количество простых чисел: %d", counter));
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Затраченное время: %d", endTime - startTime));
    }
}

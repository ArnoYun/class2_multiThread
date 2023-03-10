package org.example;

public class FindSimpleNumAmount extends Thread {
    private int[] array;
    int start;
    int end;

    public FindSimpleNumAmount(int[] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }


    private boolean isSimplestNumber(int number) {
        int firstSimpleNumber = 2;
        for (int i = number > firstSimpleNumber ? firstSimpleNumber:firstSimpleNumber + 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    int counter;

    public void run(){
        System.out.println(String.format("Thread started in range: %d:%d", start, end));
        for (int i = start; i <= end; i++) {
            if (isSimplestNumber(array[i])) {
                counter++;
//                System.out.println(array[i]);
            }
        }
    }

}

//Task 2: Parallel Number Summation
//Create a Java program that calculates the sum of numbers
// from an array in parallel using multiple threads.
//In this exercise, each thread calculates the sum of a portion of the numbers.
//Hint: Generate first an array of, e.g., 100000, random integer numbers.
//Then check how many processor cores you have in your computer
// (Runtime.getRuntime().availableProcessors()),
// and divide the array to so many equal sized portions
// that are given to separate threads to calculate the sum.

import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int processors = Runtime.getRuntime().availableProcessors();
        int size = 100_000_000;
        int amp =20;
        int subSize = size/processors;
        //create an array all threads can access
        resultArray results = new resultArray();
        double[] randNums = new double[size];
        double num;
        for (int i = 0; i < size; i++) {
            num = (Math.random() * amp);
            randNums[i] = num;
        }
        System.out.println(subSize);
        double[][] subArrays = divideIntoSubArrays(processors, randNums);
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < subArrays.length; i++) {
            System.out.println("Subarray "+i+" assigned to a thread. Length: "+(subArrays[i].length));
            threads.add(new sumArray(subArrays[i], results));
        }
        System.out.println("Assigned threads: "+threads);

        long threadStart = System.nanoTime();
        for (Thread thread : threads) {
            thread.start();
        }
        int lenght=0;
        long lastMsg = 0;
        while(lenght<processors) {
            //wait for threads to finish
            lenght =results.getArray().size();
            if (System.nanoTime() - lastMsg > 1_000_000_000L){
                System.out.printf("Waited for %.2f seconds, threads finished: "+lenght+"\n", (System.nanoTime()-threadStart)/1_000_000_000.0);
                lastMsg = System.nanoTime();
            }
        }
        double sum = 0;
        for (int i = 0; i < results.getArray().toArray().length; i++) {
            sum+=results.getArray().get(i);
        }

        long finish = System.nanoTime();
        System.out.println(
                        "\n     Total sum: "+sum+
                        "\n    Total time: "+(finish-start)/10e6+"ms"+
                        "\n       Threads: "+processors+
                        "\nPreparing took: "+(threadStart-start)/10e6+"ms"+
                        "\n  Threads took: "+(finish-threadStart)/10e6+"ms");
    }

    //*
    public static double[][] divideIntoSubArrays(int N, double[] array) {
        // Each bucket has the size (which is not a whole number)
        float bucketSize = array.length / (float) N;
        System.out.println("Bucket size is "+ bucketSize);

        double[][] result = new double[N][];

        for (int currentBucket = 0; currentBucket < N; currentBucket++) {
            // In this bucket are all the values from currentBucket * bucketSize up to currentBucket * bucketSize + bucketSize
            result[currentBucket] = Arrays.copyOfRange(array, (int) Math.ceil(currentBucket * bucketSize), (int) Math.ceil(currentBucket * bucketSize + bucketSize));
        }
        return result;
    }
    //*
}
// *Source - https://stackoverflow.com/a/71338061
// Posted by fravolt
// Retrieved 2026-05-28, License - CC BY-SA 4.0

class sumArray extends Thread {
    private double result;
    private final double[] array;
    protected resultArray results;
    sumArray(double[] array, resultArray results) {
        this.array = array;
        this.results = results;
    }

    public void run(){
        long start = System.nanoTime();
        for (double v : this.array) {
            this.result += v;
        }
        //since run() doesnt allow any return, we will instead use the resultArray to store results into
        System.out.printf("%-36s Operation took %s",
                Thread.currentThread().getName()+ ": Sum is "+this.result+",",
                (System.nanoTime()-start)/10e6+" ms.\n");
        this.results.addDouble(this.result);
    }
}

class resultArray{
    private final ArrayList<Double> array = new ArrayList<>();
    protected void addDouble(double dbl){
        array.add(dbl);
    }
    protected ArrayList<Double> getArray(){
        return array;
    }
}
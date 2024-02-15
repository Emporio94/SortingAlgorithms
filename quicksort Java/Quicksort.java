import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Quicksort {

    private static void quicksort(ArrayList<Integer> array) {
        quicksort(array, 0, array.size() - 1);
    }

    private static void quicksort(ArrayList<Integer> array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = array.size()-1;
        int pivot = array.get(pivotIndex);
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);
    }

    private static int partition(ArrayList<Integer> array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {
            while (array.get(leftPointer) <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (array.get(rightPointer) >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        if (array.get(leftPointer) > array.get(highIndex)) {
            swap(array, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;
        }

        return leftPointer;
    }

    private static void swap(ArrayList<Integer> array, int index1, int index2) {
        int temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }

    



    public static void main(String[] args) {
        ArrayList<Integer> unsortedArray = new ArrayList<>(); // Create an ArrayList object

        try {
            FileInputStream fis = new FileInputStream("int500k.txt");
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {
                unsortedArray.add(Integer.parseInt(sc.nextLine().trim()));
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Size of the Array is: " + unsortedArray.size());

        System.out.println("Starting test for QuickSort");
        long time1 = System.currentTimeMillis();
        quicksort(unsortedArray);
        long time2 = System.currentTimeMillis();
        long timeTaken = time2 - time1;
        System.out.println("The time taken to complete this algorithm is " + timeTaken + " milliseconds");



    }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HybridSort {

    // Chosen length when to initiate insertionArray
    private static final int K = 10; 

    public static void hybridQuicksort(ArrayList<Integer> array) {
        hybridQuicksort(array, 0, array.size() - 1);
        insertionSort(array); // Finally, apply Insertion Sort to the entire list
    }

    private static void hybridQuicksort(ArrayList<Integer> array, int low, int high) {
        if (low < high) {
            if (high - low < K) { // If the size of the subarray is less than K, leave it unsorted
                return;
            } else {
                int pivotIndex = partition(array, low, high);
                hybridQuicksort(array, low, pivotIndex - 1);
                hybridQuicksort(array, pivotIndex + 1, high);
            }
        }
    }

    private static int partition(ArrayList<Integer> array, int low, int high) {
        int pivot = array.get(high);
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array.get(j) < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(array, i, j);
            }
        }
        // Swap arr[i+1] and arr[high] (or pivot)
        swap(array, i + 1, high);
        return i + 1;
    }

    private static void insertionSort(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++) {
            int key = array.get(i);
            int j = i - 1;

            /* Move elements of array[0..i-1], that are greater than key,
               to one position ahead of their current position */
            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                j = j - 1;
            }
            array.set(j + 1, key);
        }
    }

    private static void swap(ArrayList<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    // Example usage
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
        System.out.println("---------------------------------------------------------\n");
        System.out.println("Size of the Array is: " + unsortedArray.size());

        System.out.println("Starting test for HybridSort algorithm ->\nQuickSort with Insertion Sort with K = " + K);
        long time1 = System.currentTimeMillis();
        hybridQuicksort(unsortedArray);
        long time2 = System.currentTimeMillis();
        long timeTaken = time2 - time1;
        System.out.println("\nThe time taken to complete this algorithm is " + timeTaken + " milliseconds");
        System.out.println("\n---------------------------------------------------------");



    }
}

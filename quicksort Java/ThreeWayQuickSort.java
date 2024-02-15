import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreeWayQuickSort {

    public static void threeWayQuicksort(ArrayList<Integer> array) {
        threeWayQuicksort(array, 0, array.size() - 1);
    }

    private static void threeWayQuicksort(ArrayList<Integer> array, int low, int high) {
        if (low >= high) return;

    
        int pivot = array.get(low);
        int lt = low, gt = high;
        int i = low + 1;

        while (i <= gt) {
            if (array.get(i).compareTo(pivot) < 0) {
                swap(array, lt++, i++);
            } else if (array.get(i).compareTo(pivot) > 0) {
                swap(array, i, gt--);
            } else {
                i++;
            }
        }

        // Recursively sort the two parts
        threeWayQuicksort(array, low, lt - 1);
        threeWayQuicksort(array, gt + 1, high);
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
        System.out.println("Size of the Array is: " + unsortedArray.size());

        System.out.println("Starting test for ThreeWayQuickSort");
        long time1 = System.currentTimeMillis();
        threeWayQuicksort(unsortedArray);
        long time2 = System.currentTimeMillis();
        long timeTaken = time2 - time1;
        System.out.println("The time taken to complete this algorithm is " + timeTaken + " milliseconds");



    }
}

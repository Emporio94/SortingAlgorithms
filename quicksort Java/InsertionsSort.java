import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionsSort {


    public static void insertionSort(ArrayList<Integer> array) {
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

    public static void main(String[] args) {
        ArrayList<Integer> unsortedArray = new ArrayList<>(); // Create an ArrayList object

        try {
            FileInputStream fis = new FileInputStream("int1000.txt");
            Scanner sc = new Scanner(fis);

            while (sc.hasNextLine()) {
                unsortedArray.add(Integer.parseInt(sc.nextLine().trim()));
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n\n---------------------------------------------------------\n");
        System.out.println("Size of the Array is: " + unsortedArray.size());

        System.out.println("Starting test for Insertion sort");
        long time1 = System.currentTimeMillis();
        insertionSort(unsortedArray);
        long time2 = System.currentTimeMillis();
        long timeTaken = time2 - time1;
        System.out.println("The time taken to complete this algorithm is " + timeTaken + " milliseconds");
        System.out.println("\n---------------------------------------------------------");



    }
    
}

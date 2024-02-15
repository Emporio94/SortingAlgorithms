import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ShellSort {

    public static void shellSort(ArrayList<Integer> array) {
        int n = array.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {
 
            for (int i = gap; i < n; i += 1) {
                // add array[i] to the elements that have been gap sorted
                // save array[i] in temp and make a hole at position i
                int temp = array.get(i);

                int j;
                for (j = i; j >= gap && array.get(j - gap) > temp; j -= gap) {
                    array.set(j, array.get(j - gap));
                }

                array.set(j, temp);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> unsortedArray = new ArrayList<>(); 

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

        System.out.println("Starting test for ShellSort");
        long time1 = System.currentTimeMillis();
        shellSort(unsortedArray);
        long time2 = System.currentTimeMillis();
        long timeTaken = time2 - time1;
        System.out.println("The time taken to complete this algorithm is " + timeTaken + " milliseconds");
        System.out.println("\n---------------------------------------------------------");
    }
}


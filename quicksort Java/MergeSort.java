import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MergeSort {

    public static void main(String[] args) {
        ArrayList<Integer> unsortedArray = new ArrayList<>();

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

        System.out.println("Starting test for MergeSort algorithm ");
        long time1 = System.currentTimeMillis();
        mergeSort(unsortedArray, 0, unsortedArray.size() - 1);
        long time2 = System.currentTimeMillis();
        long timeTaken = time2 - time1;
        System.out.println("The time taken to complete this algorithm is " + timeTaken + " milliseconds");
    }

    private static void mergeSort(ArrayList<Integer> inputArray, int fromIndex, int toIndex) {
        if (fromIndex < toIndex) {
            int midIndex = (fromIndex + toIndex) / 2;
            mergeSort(inputArray, fromIndex, midIndex);
            mergeSort(inputArray, midIndex + 1, toIndex);
            merge(inputArray, fromIndex, midIndex, toIndex);
        }
    }

    private static void merge(ArrayList<Integer> inputArray, int fromIndex, int midIndex, int toIndex) {
        ArrayList<Integer> leftArray = new ArrayList<>(inputArray.subList(fromIndex, midIndex + 1));
        ArrayList<Integer> rightArray = new ArrayList<>(inputArray.subList(midIndex + 1, toIndex + 1));

        int leftIndex = 0, rightIndex = 0;
        int mergeIndex = fromIndex;
        while (leftIndex < leftArray.size() && rightIndex < rightArray.size()) {
            if (leftArray.get(leftIndex) <= rightArray.get(rightIndex)) {
                inputArray.set(mergeIndex, leftArray.get(leftIndex++));
            } else {
                inputArray.set(mergeIndex, rightArray.get(rightIndex++));
            }
            mergeIndex++;
        }

        while (leftIndex < leftArray.size()) {
            inputArray.set(mergeIndex++, leftArray.get(leftIndex++));
        }

        while (rightIndex < rightArray.size()) {
            inputArray.set(mergeIndex++, rightArray.get(rightIndex++));
        }
    }

}

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem2 {
    public static void main(String[] args) throws FileNotFoundException {
        // Problem Name: Red-Nosed Reports Part 2
        Scanner scan = new Scanner(new File("./Day2/input.in"));
        ArrayList<int[]> arr = new ArrayList<int[]>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim(); // Read the line and trim any extra spaces
            String[] numbers = line.split("\\s+"); // Split based on whitespace
            int[] nums = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                nums[i] = Integer.parseInt(numbers[i]);
            }
            arr.add(nums);
        }
        scan.close();

        Solution(arr);
        // Solution: 349
    }

    public static void Solution(ArrayList<int[]> arr) {
        int output = 0;
        for (int[] i : arr) {
            if (isSafe(i)) {
                output++;
            } else if (canBeMadeSafe(i)) {
                output++;
            }
        }
        System.out.println(output + " reports are safe.");
    }

    public static boolean canBeMadeSafe(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Create a new array with the i-th level removed
            int[] modifiedArr = new int[arr.length - 1];
            int k = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) { // skips one
                    modifiedArr[k++] = arr[j];
                }
            }

            if (isSafe(modifiedArr)) {
                return true;
            }
        }

        return false;
    }

    // Helper Methods

    public static boolean isSafe(int[] arr) {
        boolean decreasing = true, increasing = true;
        int previous = arr[0];
        int difference;

        for (int i = 1; i < arr.length; i++) { // Iterates
            if (decreasing && previous <= arr[i]) {
                decreasing = false;
            }
            if (increasing && previous >= arr[i]) {
                increasing = false;
            }
            if (!increasing && !decreasing) {
                return false;
            }

            // Checks range
            difference = Math.abs(previous - arr[i]);
            if (difference < 1 || difference > 3) {
                return false;
            }

            previous = arr[i];
        }

        return decreasing || increasing;
    }
}
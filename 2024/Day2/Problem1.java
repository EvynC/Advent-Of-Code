import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem1 {
    public static void main(String[] args) throws FileNotFoundException {
        // Problem Name: Red-Nosed Reports Part 1
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
        // Solution: 282
    }

    public static void Solution(ArrayList<int[]> arr) {
        int output = 0;
        for (int[] i : arr) {
            if (isSafe(i)) {
                output++;
            }
        }
        System.out.println(output + " reports are safe.");
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
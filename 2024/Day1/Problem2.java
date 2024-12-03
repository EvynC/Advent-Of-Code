package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) throws FileNotFoundException {
        // Historian Hysteria Part 2

        // PARSE DATA
        Scanner scan = new Scanner(new File("/Day1/input.in"));

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        while (scan.hasNextLine()) {
            list1.add(scan.nextInt());
            list2.add(scan.nextInt());
        }

        scan.close();

        Solution(list1, list2);
        // Solution: 22014209
    }

    public static void Solution(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> list1 = arr1;
        ArrayList<Integer> list2 = arr2;

        int output = 0;

        for (int i : arr1) {
            output += (i * appears(i, arr2));
        }

        System.out.println("Total Similarity Score: " + output);
    }

    public static int appears(int i, ArrayList<Integer> arr) {
        int c = 0;

        for (int j : arr) {
            if (j == i)
                c++;
        }
        return c;
    }
}
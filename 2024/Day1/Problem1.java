package Day1;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem1 {
    public static void main(String[] args) throws FileNotFoundException {
        // Historian Hysteria Part 1

        // PARSE DATA
        Scanner scan = new Scanner(new File("./2024/Day1/input.txt"));

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        while (scan.hasNextLine()) {
            list1.add(scan.nextInt());
            list2.add(scan.nextInt());
        }

        scan.close();

        new Problem1(list1, list2);
    }

    public Problem1(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> list1 = sortArr(arr1);
        ArrayList<Integer> list2 = sortArr(arr2);

        int output = 0;

        for (int i = 0; i < list1.size(); i++) {
            output += Math.abs(list1.get(i) - list2.get(i));
        }

        System.out.println("Total Difference: " + output);
        // Answer: 1938424
    }

    public ArrayList<Integer> sortArr(ArrayList<Integer> arr) {
        // ArrayList Insertion sort

        for (int i = 1; i < arr.size(); i++) {
            int key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > key) {
                arr.set(j + 1, arr.get(j));
                j--;
            }

            arr.set(j + 1, key);
        }

        return arr;
    }
}

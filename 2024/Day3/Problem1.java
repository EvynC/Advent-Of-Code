package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {

    private static ArrayList<String> corruptedData;
    private static ArrayList<Integer> muls;

    public static void main(String[] args) {
        // Problem Name: Mull It Over - Part 1
        initializeData();

        int output = 0;
        for (int i = 0; i < muls.size(); i += 2) {
            output += isValidMul(i);
        }
        System.out.println("Answer: " + output);
        // Answer: 173517243
    }

    private static int isValidMul(int index) {
        String line = corruptedData.get(muls.get(index + 1));
        line = line.substring(muls.get(index));

        // Extract up to the next closing parenthesis
        int closeIndex = line.indexOf(")");
        if (closeIndex == -1) {
            return 0;
        }
        line = line.substring(0, closeIndex + 1);

        // Ensure it contains the necessary structure
        if (!line.contains("(") || !line.contains(",") || !line.contains(")")) {
            return 0;
        }

        try {
            // Extract numbers inside "mul(X,Y)"
            int num1 = Integer.parseInt(line.substring(4, line.indexOf(",")));
            int num2 = Integer.parseInt(line.substring(line.indexOf(",") + 1, line.indexOf(")")));
            return num1 * num2;
        } catch (Exception e) {
            return 0;
        }
    }

    private static void initializeData() {
        try {
            File input = new File("./Day3/input.in");
            Scanner scan = new Scanner(input);
            muls = new ArrayList<>();
            corruptedData = new ArrayList<>();

            int lineNumber = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                corruptedData.add(line);

                // Find all "mul" occurrences in the line
                for (int i = 0; i < line.length() - 3; i++) {
                    if (line.startsWith("mul", i)) {
                        muls.add(i);
                        muls.add(lineNumber);
                    }
                }
                lineNumber++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be opened.");
            e.printStackTrace();
        }
    }
}

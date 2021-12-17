import java.io.*;
import java.util.ArrayList;

public class Challenges {
    // Day One - Sonar Sweep:
    public void SonarSweep() {
        try {
            System.out.println("\n\nSonar Sweep - Part 1");

            // This will read a .txt file
            FileInputStream file = new FileInputStream("puzzle_inputs/sonar/puzzle_input.txt");
            DataInputStream data = new DataInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(data));

            String line;

            // This array will store the values of the .txt file
            ArrayList<Integer> numbers = new ArrayList<Integer>();

            // This loop will store the numbers in the file into an array
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }

            int previousNum = numbers.get(0);
            int counter = 0;

            // This loop will check the difference between the previous number and the
            // current number
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) > previousNum) {
                    counter++;
                }

                previousNum = numbers.get(i);
            }

            System.out.println("\nThe number of measurements that are larger than the previous ones are: " + counter);

            System.out.println("\n\nSonar Sweep - Part 2");

            int x, y, z;
            int sum, previousSum = 0;
            int counterSum = 0;

            for (int i = 0; i < (numbers.size() - 2); i++) {
                x = numbers.get(i);
                y = numbers.get(i + 1);
                z = numbers.get(i + 2);

                sum = x + y + z;

                if (i == 0) {
                    previousSum = sum;
                }

                if (sum > previousSum) {
                    counterSum++;
                }

                previousSum = sum;
            }

            System.out.println("\nThe number of sums that are larger than the previous ones are: " + counterSum);

            reader.close();
        } catch (Exception error) {
            System.out.println("Error: " + error);
        }
    }

    // Day two:
    public void Dive() {
        try {
            FileInputStream file = new FileInputStream("puzzle_inputs/dive/puzzle_input.txt");
            DataInputStream data = new DataInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(data));

            reader.close();
        } catch (Exception error) {
            System.out.println("\n\nError: " + error);
        }
    }
}

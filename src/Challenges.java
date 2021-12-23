import java.io.*;
import java.util.ArrayList;

public class Challenges {
    // Day One:
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

    // Day Two:
    public void Dive() {
        try {
            System.out.println("\n\nDive! - Part 1");

            FileInputStream file = new FileInputStream("puzzle_inputs/dive/puzzle_input.txt");
            DataInputStream data = new DataInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(data));

            String line;

            ArrayList<String> lines = new ArrayList<String>();
            ArrayList<String> commands = new ArrayList<String>();
            ArrayList<Integer> numbers = new ArrayList<Integer>();

            // Adds the lines of the file to an array
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // Split each string in the "lines" array into two arrays: the number arrays and
            // the commands arrays
            for (int i = 0; i < lines.size(); i++) {
                String[] string = lines.get(i).split(" ");

                for (int j = 0; j < string.length; j++) {
                    if (string[j].matches("[0-9]")) {
                        numbers.add(Integer.parseInt(string[j]));
                    } else {
                        commands.add(string[j]);
                    }
                }
            }

            int horizontalPos = 0, depth = 0;

            for (int i = 0; i < commands.size(); i++) {
                if (commands.get(i).equals("forward")) {
                    horizontalPos += numbers.get(i);
                } else if (commands.get(i).equals("down")) {
                    depth += numbers.get(i);
                } else if (commands.get(i).equals("up")) {
                    depth -= numbers.get(i);
                }
            }

            System.out.println("\nThe horizontal position is: " + horizontalPos + "\nThe depth is: " + depth
                    + "\nThe multiplication of the horizontal position and the depth is: " + (horizontalPos * depth));

            System.out.println("\n\nDive! - Part 2");

            int aim = 0;
            depth = 0;
            horizontalPos = 0;

            for (int i = 0; i < commands.size(); i++) {
                if (commands.get(i).equals("forward")) {
                    horizontalPos += numbers.get(i);
                    depth += numbers.get(i) * aim;
                } else if (commands.get(i).equals("down")) {
                    aim += numbers.get(i);
                } else if (commands.get(i).equals("up")) {
                    aim -= numbers.get(i);
                }
            }

            System.out.println("\nThe new horizontal position is: " + horizontalPos + "\nThe new depth is: " + depth
                    + "\nThe new multiplication of the horizontal position and the depth is: "
                    + (horizontalPos * depth));

            reader.close();
        } catch (Exception error) {
            System.out.println("\n\nError: " + error);
        }
    }
}

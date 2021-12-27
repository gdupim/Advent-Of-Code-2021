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

    // Part three:
    public void BinaryDiagnostic() {
        try {
            System.out.println("\n\nBinary Diagnostic - Part 1");

            FileInputStream file = new FileInputStream("puzzle_inputs/binaryDiagnostic/puzzle_input.txt");
            DataInputStream data = new DataInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(data));

            String line;

            ArrayList<String> lines = new ArrayList<String>();

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            String gammaRate = "", epsilonRate = "";

            // This array will store the numbers as chars to be analyzed later
            ArrayList<Character> chars = new ArrayList<Character>();

            // These two will be used as counters of zeroes and ones
            ArrayList<Integer> ones = new ArrayList<Integer>();
            ArrayList<Integer> zeroes = new ArrayList<Integer>();

            // This loop will check each line of the "lines" array
            for (int i = 0; i < lines.size(); i++) {
                // Transforms the strings of the "lines" array into chars
                for (char c : lines.get(i).toCharArray()) {
                    chars.add(c);
                }

                // Dynamically sizes the arrays of ones and zeroes
                while (ones.size() < chars.size() && zeroes.size() < chars.size()) {
                    ones.add(0);
                    zeroes.add(0);
                }

                // Counts the ones and zeroes of each position in the "chars" array
                for (int j = 0; j < chars.size(); j++) {
                    if (chars.get(j) == '1') {
                        ones.set(j, ones.get(j) + 1);
                    } else {
                        zeroes.set(j, zeroes.get(j) + 1);
                    }
                }

                // Clears the array to be used again
                chars.clear();
            }

            // Checks each position of both arrays and see if or zero or one is the most
            // or least frequent
            for (int i = 0; i < ones.size(); i++) {
                if (ones.get(i) > zeroes.get(i)) {
                    gammaRate += "1";
                    epsilonRate += "0";
                } else {
                    gammaRate += "0";
                    epsilonRate += "1";
                }
            }

            long gammaRateDecimal = BinaryToDecimal(Long.parseLong(gammaRate));
            long epsilonRateDecimal = BinaryToDecimal(Long.parseLong(epsilonRate));

            System.out.println("\nThe gamma rate (binary) is: " + gammaRate
                    + "\nThe epsilon rate (binary) is: " + epsilonRate
                    + "\nThe gamma rate (decimal) is: " + gammaRateDecimal
                    + "\nThe epsilon rate (decimal) is: " + epsilonRateDecimal
                    + "\nThe multiplication (in decimal) of the gamma rate and the epsilon rate is: "
                    + gammaRateDecimal * epsilonRateDecimal);

            reader.close();
        } catch (

        Exception error) {
            System.out.println("\n\nError: " + error);
        }
    }

    public int BinaryToDecimal(long binary) {
        int decimal = 0;
        char[] binaryArray = Long.toString(binary).toCharArray();

        for (int i = 0, power = (binaryArray.length - 1); i < binaryArray.length; i++, power--) {
            decimal += (Character.getNumericValue(binaryArray[i]) * Math.pow(2, power));
        }

        return decimal;
    }
}

import java.io.IOException;
import java.util.Scanner;

public class Index {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Challenges challenges = new Challenges();
        int op = 1;

        System.out.println("\n\nAdvent Of Code - 2021");

        while (op == 1) {
            try {
                System.out.println("\nChoose a day of the challenge to see the results of it: "
                        + "\n[0] - Exit"
                        + "\n[1] - Sonar Sweep"
                        + "\n[2] - Dive!"
                        + "\n\nType here your choice: ");
                int option = scan.nextInt();

                switch (option) {
                    case 0:
                        System.out.println("\n\nGoodbye!");
                        op = 0;
                        break;

                    case 1:
                        clearScreen();
                        challenges.SonarSweep();
                        break;

                    case 2:
                        clearScreen();
                        challenges.Dive();
                        break;

                    default:
                        break;
                }

            } catch (Exception error) {
                if (error.toString().equals("java.util.InputMismatchException")) {
                    scan.nextLine();
                    System.out.println("\nPlease, type a valid option and try again.");
                    System.out.println("\nWant to try again?"
                            + "\n[1] - Yes"
                            + "\n[2] - No"
                            + "\n\nType here your choice: ");
                    op = scan.nextInt();

                    if (op != 1) {
                        op = 2;
                    } else {
                        clearScreen();
                    }
                }
            }
        }

        scan.close();
    }

    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}

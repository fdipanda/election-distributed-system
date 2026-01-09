import java.rmi.*;
import java.util.Scanner;

public class ElectionClient {

    public static void main(String[] args) {
        try {
            int port = 1099;

            String registryURL = "rmi://localhost:" + port + "/Election";
            ElectionInterface election = (ElectionInterface) Naming.lookup(registryURL);

            System.out.println("Connected to Election Server.");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Election Menu ---");
                System.out.println("1. Cast Vote");
                System.out.println("2. View Results");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // consume newline

                if (choice == 1) {
                    System.out.print("Vote for candidate (A or B): ");
                    String vote = scanner.nextLine().trim();

                    election.castVote(vote);
                    System.out.println("Your vote has been submitted.");
                }
                else if (choice == 2) {
                    int[] results = election.getResult();
                    System.out.println("\n--- Current Results ---");
                    System.out.println("Candidate A: " + results[0]);
                    System.out.println("Candidate B: " + results[1]);
                }
                else if (choice == 3) {
                    System.out.println("Exiting client...");
                    break;
                }
                else {
                    System.out.println("Invalid menu choice.");
                }
            }

            scanner.close();

        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}

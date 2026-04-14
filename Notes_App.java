
import java.io.*;
import java.util.Scanner;

public class Notes_App {
    private static final String FILE_NAME = "notes.txt";

    // Method to add a note
    public static void addNote(String note) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true); // true = append mode
            fw.write(note + "\n");
            fw.close();
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Method view notes
    public static void viewNotes() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                System.out.println(" No notes found.");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            System.out.println("\n Your Notes:");
            System.out.println("----------------------");

            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Notes App =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    addNote(note);
                    break;

                case 2:
                    viewNotes();
                    break;

                case 3:
                    System.out.println(" Exiting... Bye!");
                    sc.close();
                    return;

                default:
                    System.out.println(" Invalid choice!");
            }
        }
    }
}
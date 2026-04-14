package task3;
import java.util.*;

public class Main {
    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Show Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(bId, title, author));
                    System.out.println("Book added!");
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    library.addUser(new User(uId, name));
                    System.out.println("User added!");
                    break;

                case 3:
                    library.showBooks();
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int issueBookId = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int issueUserId = sc.nextInt();

                    library.issueBook(issueBookId, issueUserId);
                    break;

                case 5:
                    System.out.print("Enter Book ID: ");
                    int returnBookId = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int returnUserId = sc.nextInt();

                    library.returnBook(returnBookId, returnUserId);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                System.out.println(" Invalid Choice !");
            }
            
        }
        
    }
}
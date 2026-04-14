package task3;
import java.util.*;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Add Book
    public void addBook(Book book) {
        books.add(book);
    }

    // Add User
    public void addUser(User user) {
        users.add(user);
    }

    // Issue Book
    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null || user == null) {
            System.out.println("Book or User not found!");
            return;
        }

        if (!book.isIssued()) {
            book.issueBook();
            user.issueBook(book);
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book already issued!");
        }
    }

    // Return Book
    public void returnBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null || user == null) {
            System.out.println("Book or User not found!");
            return;
        }

        if (book.isIssued()) {
            book.returnBook();
            user.returnBook(book);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book was not issued!");
        }
    }

    // Find Book
    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    // Find User
    private User findUser(int id) {
        for (User u : users) {
            if (u.getUserId() == id) return u;
        }
        return null;
    }

    // Display Books
    public void showBooks() {
        System.out.println("\nLibrary Books:");
        for (Book b : books) {
            b.displayBook();
        }
    }
}

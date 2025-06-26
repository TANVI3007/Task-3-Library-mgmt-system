import java.util.*;
class Book {
    int id;
    String title;
    boolean isIssued = false;
    User issuedTo = null;
    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Issued: " + (isIssued ? "Yes to " + issuedTo.name : "No"));
    }
}
class User {
    int userId;
    String name;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
    public void display() {
        System.out.println("User ID: " + userId + ", Name: " + name);
    }
}
class Library {
    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        books.add(new Book(id, title));
        System.out.println("Book added.");
    }
    public void addUser() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();
        users.add(new User(id, name));
        System.out.println("User added.");
    }
    public void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int bookId = sc.nextInt();
        Book book = findBook(bookId);
        if (book == null || book.isIssued) {
            System.out.println("Book not available.");
            return;
        }
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        User user = findUser(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        book.isIssued = true;
        book.issuedTo = user;
        System.out.println("Book issued to " + user.name);
    }
    public void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int bookId = sc.nextInt();
        Book book = findBook(bookId);
        if (book == null || !book.isIssued) {
            System.out.println("Book not issued.");
            return;
        }
        System.out.println("Book returned by " + book.issuedTo.name);
        book.isIssued = false;
        book.issuedTo = null;
    }
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        for (Book b : books) {
            b.display();
        }
    }
    public Book findBook(int id) {
        for (Book b : books) {
            if (b.id == id) return b;
        }
        return null;
    }
    public User findUser(int id) {
        for (User u : users) {
            if (u.userId == id) return u;
        }
        return null;
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: library.addBook(); break;
                case 2: library.addUser(); break;
                case 3: library.issueBook(); break;
                case 4: library.returnBook(); break;
                case 5: library.viewBooks(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 6);
        sc.close();
    }
}
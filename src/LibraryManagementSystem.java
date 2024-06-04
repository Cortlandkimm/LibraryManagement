import java.util.Scanner;

public class LibraryManagementSystem {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Search Books");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBooks();
                    break;
                case 6:
                    System.out.println("Exiting the Library, Come again Soon! (:");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(title, author, genre, year);
        library.addBook(book);
    }

    private static void updateBook() {
        library.viewBooks();
        System.out.print("Enter the index of the book to update: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new author: ");
        String author = scanner.nextLine();
        System.out.print("Enter new genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter new year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Book newBook = new Book(title, author, genre, year);
        library.updateBook(index - 1, newBook);
    }

    private static void deleteBook() {
        library.viewBooks();
        System.out.print("Enter the index of the book to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        library.deleteBook(index - 1);
    }

    private static void searchBooks() {
        System.out.print("Enter a keyword to search: ");
        String keyword = scanner.nextLine();

        library.searchBooks(keyword);
    }
}


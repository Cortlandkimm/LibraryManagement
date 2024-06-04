import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private static final String FILE_PATH = "library.dat";

    // Constructor
    public Library() {
        books = new ArrayList<>();
        loadFromFile();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        if (saveToFile()) {
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Failed to save the book.");
        }
    }

    // View all books in the library
    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }

    // Update a book in the library
    public void updateBook(int index, Book newBook) {
        if (index >= 0 && index < books.size()) {
            books.set(index, newBook);
            if (saveToFile()) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("Failed to save the updated book.");
            }
        } else {
            System.out.println("Invalid index. No book updated.");
        }
    }

    // Delete a book from the library
    public void deleteBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
            if (saveToFile()) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Failed to save after deletion.");
            }
        } else {
            System.out.println("Invalid index. No book deleted.");
        }
    }

    // Search for books by a keyword
    public void searchBooks(String keyword) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword) || book.getGenre().contains(keyword)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found matching the keyword.");
        }
    }

    // Save the books list to a file
    private boolean saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(books);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Load the books list from a file
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            books = (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            books = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}



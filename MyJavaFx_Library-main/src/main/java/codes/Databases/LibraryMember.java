package codes.Databases;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private String name;
    private String password;
    private String email;
    private int age;
    private String phoneNumber;
    private List<Books> borrowedBooks;

    public LibraryMember(String name, String password, String email, int age, String  phoneNumber) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Add a book to member's borrowed books list
    public void addBorrowedBook(Books book) {
        borrowedBooks.add(book);
    }

    // Remove a book from member's borrowed books list
    public boolean removeBorrowedBook(Books book) {
        return borrowedBooks.remove(book);
    }

    // Get the list of borrowed books
    public List<Books> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Display all borrowed books
    public void displayBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println("No books currently borrowed.");
            return;
        }

        System.out.println("\nCurrently Borrowed Books:");
        System.out.printf("%-5s | %-30s | %-25s%n", 
            "No.", "Title", "Author");
        System.out.println("------------------------------------------------------------------------------");

        int counter = 1;
        for (Books book : borrowedBooks) {
            System.out.printf("%-5d | %-30s | %-25s%n", 
                counter++, 
                book.getTitle(), 
                book.getAuthor());
        }
    }

    // Check if member has borrowed a specific book
    public boolean hasBorrowedBook(Books book) {
        return borrowedBooks.contains(book);
    }

    // Get number of books currently borrowed
    public int getBorrowedBookCount() {
        return borrowedBooks.size();
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Age: " + age + 
               ", Phone: " + phoneNumber + ", Books Borrowed: " + getBorrowedBookCount();
    }
}
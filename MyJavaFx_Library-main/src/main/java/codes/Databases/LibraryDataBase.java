package codes.Databases;

import java.util.ArrayList;
import java.util.HashMap;
public class LibraryDataBase {
    // HashMap for library members
    protected static HashMap<String, LibraryMember> members = new HashMap<>();
    public static int memberCounter = 0;
    protected static ArrayList<Books> books = new ArrayList<>();

    public void initializeDatabase() {
        addLibraryMember("Kyle", "1111", "kyle@gmail.com", 20, "09123456789");
        addLibraryMember("Allen", "1111", "allen@gmail.com", 21, "09234567890");
        addLibraryMember("Rjay", "1111", "rjay@gmail.com", 22, "09345678901");
        addLibraryMember("Jansean", "1111", "jansean@gmail.com", 23, "09456789012");
        addLibraryMember("Kelly", "1111", "kelly@gmail.com", 21, "09234567890");
        addLibraryMember("Colin", "1111", "colin@gmail.com", 22, "09345678901");
        addLibraryMember("Kayezel", "1111", "kayezel@gmail.com", 23, "09456789012");
    }

    public void initializeBookInventory() {
        addBook("To Kill a Mockingbird", "Harper Lee", 5, 5, 20);
        addBook("Pride and Prejudice", "Jane Austen", 5, 5, 20);
        addBook("Crime and Punishment", "Fyodor Dostoevsky", 5, 5, 20);
        addBook("1984", "George Orwell", 5, 0, 15);
        addBook("The Lord of the Rings", "J.R.R. Tolkien", 5, 5, 40);
        addBook("The Great Gatsby", "F. Scott Fitzgerald", 5, 5, 18);
        addBook("Noli Me Tangere", "Jose Rizal", 5, 5, 25);
        addBook("El Filibusterismo", "Jose Rizal", 5, 5, 20);
        addBook("One Piece", "Eiichiro Oda", 5, 5, 50);
        addBook("Bleach", "Tite Kubo", 5, 5, 30);
        addBook("Fairy Tail", "Hiro Mashima", 5, 5, 25);
        addBook("DanMachi", "Fujino Omori", 5, 5, 15);
        addBook("One Punch Man", "ONE", 5, 5, 35);
        addBook("Jujutsu Kaisen", "Gege Akutami", 5, 5, 40);
        
    }

    public static HashMap<String, LibraryMember> getMembers() {
        return members;
    }

    public void addLibraryMember(String name, String password, String email, int age, String phoneNumber) {
        LibraryMember member = new LibraryMember(name, password, email, age, phoneNumber);
        members.put(member.getEmail(), member);
        memberCounter = members.size();
    }

    public void addBook(String title, String author, int totalCopies, int availableCopies, int borrowCount) {
        Books book = new Books(title, author, totalCopies, availableCopies, borrowCount);
        books.add(book);
    }


    public ArrayList<Books> getBooks() {
        return books;
    }

    // Method to display all books
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found in the inventory.");
            return;
        }
    
        // Header for the book display table
        System.out.printf("%-5s | %-30s | %-25s | %-10s | %-15s | %-10s%n", 
            "No.", "Title", "Author", "Total Copies", "Available Copies", "Borrow Count");
        System.out.println("---------------------------------------------------------------------------------------------");
    
        int counter = 1;
        for (Books book : books) {
            System.out.printf("%-5d | %-30s | %-25s | %-10d | %-15d | %-10d%n", 
                counter++, 
                book.getTitle(), 
                book.getAuthor(), 
                book.getTotalCopies(), 
                book.getAvailableCopies(), 
                book.getBorrowCount());
        }
    }
    

    public boolean removeBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean verifyMemberCredentials(String email, String password) {
        LibraryMember member = members.get(email);
        return member != null && member.getPassword().equals(password);
    }

    



}
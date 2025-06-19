package codes.Databases;

public class Books {
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;
    private int borrowCount;

    public Books(String title, String author, int totalCopies, int availableCopies, int borrowCount) {
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
        this.borrowCount = borrowCount;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    // Setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    @Override
    public String toString() {
        return "Title: " + title + 
               ", Author: " + author + 
               ", Total Copies: " + totalCopies + 
               ", Available Copies: " + availableCopies +
               ", Times Borrowed: " + borrowCount;
    }
}
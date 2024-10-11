import java.util.ArrayList;
import java.util.List;

class Member {
    private int memberId;
    private String name;
    private List<Book> borrowedBooks;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Method to borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Method to return a book
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Getters
    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }
}

import java.util.HashMap;

class Library {
    private HashMap<String, Book> bookCatalog; // ISBN -> Book
    private HashMap<Integer, Member> members;  // Member ID -> Member

    public Library() {
        bookCatalog = new HashMap<>();
        members = new HashMap<>();
    }

    // Add a book to the catalog
    public void addBook(Book book) {
        bookCatalog.put(book.getISBN(), book);
    }

    // Search for a book by ISBN
    public Book searchBookByISBN(String ISBN) {
        return bookCatalog.get(ISBN);
    }

    // Add a member
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    // Borrow a book
    public void issueBook(int memberId, String ISBN) {
        Book book = searchBookByISBN(ISBN);
        if (book != null) {
            members.get(memberId).borrowBook(book);
            System.out.println("Book issued: " + book.getTitle());
        } else {
            System.out.println("Book not found");
        }
    }

    // Return a book
    public void returnBook(int memberId, String ISBN) {
        Book book = searchBookByISBN(ISBN);
        if (book != null) {
            members.get(memberId).returnBook(book);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book not found");
        }
    }
}

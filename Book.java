class Book {
    private String title;
    private String author;
    private String ISBN;
    private String location;

    public Book(String title, String author, String ISBN, String location) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.location = location;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }
    public String getLocation() { return location; }
}

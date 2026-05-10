package library.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private int publishedYear;
    private Library library;
    public Book() {}

    public Book(int id, String title, String author, int publishedYear, Library library) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.library = library;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPublishedYear() { return publishedYear; }
    public void setPublishedYear(int publishedYear) { this.publishedYear = publishedYear; }

    public Library getLibrary() { return library; }
    public void setLibrary(Library library) { this.library = library; }
}

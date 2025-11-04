package librarymanagementsystem.model;

public class Book {
	
	private int id;
    private String title;
    private String author;
    private String publisher;
    private int availableCopies;

    public Book() {}

    public Book(String title, String author, String publisher, int availableCopies) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.availableCopies = availableCopies;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getAvailableCopies() { return availableCopies; }
    public void setAvailableCopies(int availableCopies) { this.availableCopies = availableCopies; }

}

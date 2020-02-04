import java.util.UUID;

public class Book {

    private String isbn;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private int edition;
    private String publisher;
    private int publishYear;
    private int pages;
    private String language;

    public Book(String isbn, String title, String authorFirstName, String authorLastName, int edition, String publisher, int publishYear, int pages, String language) {
        this.isbn = isbn;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.edition = edition;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.pages = pages;
        this.language = language;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn +
                "\nTitel: " + title +
                "\nFörfattare: " + authorFirstName + " " + authorLastName +
                "\nUpplaga: " + edition +
                "\nFörlag: " + publisher +
                "\nUtgivningsår " + publishYear +
                "\nAntal sidor: " + pages +
                "\nSpråk: " + language;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() { return title; }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() { return authorLastName; }

    public int getEdition() {
        return edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublishYear() { return publishYear; }

    public int getPages() { return pages; }

    public String getLanguage() { return language; }


}


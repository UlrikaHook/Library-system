import java.util.UUID;

public class BookCopy extends Book {

    private String id;

    private boolean available;

    public BookCopy(String isbn, String title, String authorFirstName, String authorLastName, int edition, String publisher, int publishYear, int pages, String language) {
        super(isbn, title, authorFirstName,authorLastName,edition,publisher,publishYear,pages,language);
        this.id = UUID.randomUUID().toString();
        this.available = true;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "ISBN: " + super.getIsbn() +
                "\nTitel: " + super.getTitle() +
                "\nFörfattare: " + super.getAuthorFirstName() + " " + super.getAuthorLastName() +
                "\nUpplaga: " + super.getEdition() +
                "\nFörlag: " + super.getPublisher() +
                "\nUtgivningsår " + super.getPublishYear() +
                "\nAntal sidor: " + super.getPages() +
                "\nSpråk: " + super.getLanguage() +
                "\nTillgänglig: " + (available == true ? "ja" : "nej");
    }

    public boolean isAvailable() {
        return available;
    }

    public String getId() {
        return id;
    }



}

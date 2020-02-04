import java.sql.SQLException;

public class LibraryUI {

    //Senare lägga till ui

    public void addBook() throws SQLException {
        String isbn = "9789144085878";
        String title = "Java : steg för steg";
        String authorFirstName = "Jan";
        String authorLastName = "Skansholm";
        int edition = 1;
        String publisher = "Studentlitteratur";
        int publishYear = 2012;
        int pages = 501;
        String language = "Svenska";

        Book book = new Book(isbn, title, authorFirstName,
                authorLastName, edition, publisher, publishYear, pages, language);
        System.out.println(new DBAdminBook().insert(book));

        int nrOfCopies = 3;
        for(int i = 0; i < nrOfCopies; i++){
            System.out.println(new DBAdminBookCopy().insert
                    (new BookCopy(isbn, title, authorFirstName, authorLastName, edition, publisher, publishYear, pages, language)));
        }
    }

    public void addUser() throws SQLException {
        User user = new User("Ulrika", "Hook", "070268811", "hook.ulrika@gmail.com");
        System.out.println(new DBAdminUser().insert(user));
    }

    public void deleteBook() throws SQLException {
        String isbn = "9789144085876";
        System.out.println(new DBAdminBook().delete(isbn));
    }

    public void deleteBookCopy() throws SQLException {
        String copyId = "42885520-57bc-4fc5-89d7-4fbee7e2a263";
        System.out.println(new DBAdminBookCopy().delete(copyId));
    }

    public void deleteUser() throws SQLException {
        String userId = "9d65d09b-0dc9-494a-968a-a7efd729f6f0";
        System.out.println(new DBAdminUser().delete(userId));
    }

    public void editUser() throws SQLException{
        String userId = "bc905d23-a0fa-4cb5-a2d3-709d8d685e82";
        System.out.println(new DBAdminUser().edit(userId, "nyman.ulrika@gmail.com", EditColumns.EMAIL));
        //System.out.println(new DatabaseHandler().editUserPhone(userId, "0702987809", EditColumns.PHONE));
        //System.out.println(new DatabaseHandler().editUserFirstname(userId, "Elenore", EditColumns.FIRSTNAME));
        //System.out.println(new DatabaseHandler().editUserLastname(userId, "Nyman", EditColumns.LASTNAME));
    }


    public void regLoan() throws SQLException{
        String userId = "bc905d23-a0fa-4cb5-a2d3-709d8d685e82";
        String copyId = "9a96bdc0-50a9-4be9-b8a9-effb3b52055d";

        System.out.println(new DBAdminBookIssue().regIssue(userId, copyId));
    }


    //Här ska
    // kunna lämna tillbaka
    // kunna ta fram alla lån för en user
    // kunna ta fram om en bok är tillgänglig eller inte

}



import java.util.UUID;

public class User {
    private String id;
    private String firstName;
    private String lastname;
    private String phoneNumber;
    private String email;

    public User(String firstName, String lastname, String phoneNumber, String email) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nFörnamn: " + firstName +
                "\nEfternamn: " + lastname +
                "\nTelefonnummer: " + phoneNumber +
                "\nE-post: " + email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}

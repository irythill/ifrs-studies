public class Author {
    private int authorsId;
    private String firstName;
    private String lastName;


    public Author(int authorsId, String firstName, String lastName) {
        this.authorsId = authorsId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(int authorsId) {
        this.authorsId = authorsId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

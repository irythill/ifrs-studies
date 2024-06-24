public class AuthorTitle {
    private int atAuthorsId;
    private int atISBN;

    public AuthorTitle(int atAuthorsId, int atISBN) {
        this.atAuthorsId = atAuthorsId;
        this.atISBN = atISBN;
    }

    public int getAtAuthorsId() {
        return atAuthorsId;
    }

    public void setAtAuthorsId(int atAuthorsId) {
        this.atAuthorsId = atAuthorsId;
    }

    public int getAtISBN() {
        return atISBN;
    }

    public void setAtISBN(int atISBN) {
        this.atISBN = atISBN;
    }
}

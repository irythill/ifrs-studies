import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthorDAO authorDao = new AuthorDAO();
        BookDAO bookDao = new BookDAO();
        Scanner scanner = new Scanner(System.in);

        boolean closeMenu = false;

        do {
            System.out.println("-- CRUD REFORMED --\n");
            System.out.println("0 - Exit");
            System.out.println("1 - Create Authors");
            System.out.println("2 - Read Authors");
            System.out.println("3 - Update Authors");
            System.out.println("4 - Delete Authors");
            System.out.println("5 - Create Books");
            System.out.println("6 - Read Books");
            System.out.println("7 - Update Books");
            System.out.println("8 - Delete Books");

            System.out.println("Select your option:");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 0 -> {
                    System.out.println("Leaving...");
                    closeMenu = true;
                }

                case 1 -> {
                    System.out.println("-- Create Authors--\n");

                    System.out.println("Inform the author's first name:");
                    String firstName = scanner.nextLine();

                    System.out.println("Inform the author's last name:");
                    String lastName = scanner.nextLine();

                    Author author = new Author(firstName, lastName);

                    if (authorDao.create(author) > 0) {
                        System.out.println("Success!\n");
                    } else {
                        System.out.println("Failed!\n");
                    }
                    break;
                }
                case 2 -> {
                    System.out.println("-- Read Authors --\n");

                    ArrayList<Author> authorList = authorDao.list();

                    for (int i = 0; i < authorList.size(); i++) {
                        Author author = authorList.get(i);

                        System.out.println("ID: " + author.getAuthorsId());
                        System.out.println("First name: " + author.getFirstName());
                        System.out.println("Last name: " + author.getLastName());
                        System.out.println("\n");
                    }
                    break;
                }

                case 3 -> {
                    System.out.println("-- Update Authors --\n");

                    System.out.println("Inform the author's ID you wish to update");
                    String temp = scanner.nextLine();
                    int id = Integer.parseInt(temp);

                    Author author = authorDao.read(id);

                    if (author == null) {
                        System.out.println("Failed! Couldn't find any author!\n");
                    } else {
                        System.out.println("Do you wish to change the author's first name? 1 - YES 2 - NO");
                        temp = scanner.nextLine();
                        int firstAnswer = Integer.parseInt(temp);

                        if (firstAnswer == 1) {
                            System.out.println("Inform the new first name:");
                            String firstName = scanner.nextLine();
                            author.setFirstName(firstName);
                        }

                        System.out.println("Do you wish to change the author's last name? 1 - YES 2 - NO");
                        temp = scanner.nextLine();
                        int secondAnswer = Integer.parseInt(temp);

                        if (secondAnswer == 1) {
                            System.out.println("Inform the new last name:");
                            String lastName = scanner.nextLine();
                            author.setLastName(lastName);
                        }

                        if (authorDao.update(author) > 0) {
                            System.out.println("Success!\n");
                        } else {
                            System.out.println("Nothing has been updated!\n");
                        }
                    }
                    break;
                }

                case 4 -> {
                    System.out.println("-- Delete Authors --\n");

                    System.out.println("Inform the author's ID you wish to delete");
                    String temp = scanner.nextLine();
                    int id = Integer.parseInt(temp);

                    if (authorDao.delete(id) > 0) {
                        System.out.println("Success!\n");
                    } else {
                        System.out.println("Failed!\n");
                    }
                    break;
                }

                case 5 -> {
                    System.out.println("-- Create Books --\n");

                    System.out.println("Inform the book's ISBN:");
                    int isbn = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inform the book's title:");
                    String title = scanner.nextLine();

                    System.out.println("Inform the book's edition:");
                    String edition = scanner.nextLine();

                    System.out.println("Inform the book's copyright:");
                    String copyright = scanner.nextLine();

                    Book book = new Book(isbn, title, edition, copyright);

                    if (bookDao.create(book) > 0) {
                        System.out.println("Success!\n");
                    } else {
                        System.out.println("Failed!\n");
                    }
                    break;
                }

                case 6 -> {
                    System.out.println("-- Read Books --\n");

                    ArrayList<Book> bookList = bookDao.list();

                    for (int i = 0; i < bookList.size(); i++) {
                        Book book = bookList.get(i);

                        System.out.println("ISBN: " + book.getISBN());
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Edition Number: " + book.getEditionNumber());
                        System.out.println("Copyright: " + book.getCopyright());
                        System.out.println("\n");
                    }
                    break;
                }

                case 7 -> {
                    System.out.println("-- Update Books --\n");

                    System.out.println("Inform the book's ISBN you wish to update:");
                    String temp = scanner.nextLine();
                    int id = Integer.parseInt(temp);

                    Book book = bookDao.read(id);

                    if (book == null){
                        System.out.println("Couldn't find any books!\n");
                    } else {
                        System.out.println("Do you wish to change the book's title? 1 - YES 2 - NO");
                        temp = scanner.nextLine();
                        int firstAnswer = Integer.parseInt(temp);

                        if (firstAnswer == 1){
                            System.out.println("Inform the new title:");
                            String title = scanner.nextLine();
                            book.setTitle(title);
                        }

                        System.out.println("Do you wish to change the book's edition number? 1 - YES 2 - NO");
                        temp = scanner.nextLine();
                        int secondAnswer = Integer.parseInt(temp);

                        if (secondAnswer == 1){
                            System.out.println("Inform the new edition number:");
                            String edition = scanner.nextLine();
                            book.setEditionNumber(edition);
                        }

                        System.out.println("Do you wish to change the book's copyright? 1 - YES 2 - NO");
                        temp = scanner.nextLine();
                        int thirdAnswer = Integer.parseInt(temp);

                        if (thirdAnswer == 1){
                            System.out.println("Inform the new copyright");
                            String copyright = scanner.nextLine();
                            book.setCopyright(copyright);
                        }

                        if (bookDao.update(book) > 0) {
                            System.out.println("Success!\n");
                        } else {
                            System.out.println("Nothing has been updated!\n");
                        }
                    }
                    break;
                }

                case 8 -> {
                    System.out.println("-- Delete Books --\n");

                    System.out.println("Inform the book's ISBN you wish to delete");
                    String temp = scanner.nextLine();
                    int isbn = Integer.parseInt(temp);

                    if (bookDao.delete(isbn) > 0) {
                        System.out.println("Success!\n");
                    } else {
                        System.out.println("Failed!\n");
                    }
                    break;
                }
            }
        } while (!closeMenu);
    }
}
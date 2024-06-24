import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // DAO'S
        AuthorDAO authorDao = new AuthorDAO();
        TitleDAO titleDao = new TitleDAO();
        AuthorTitleDAO authorTitleDAO = new AuthorTitleDAO();


        // Scanner
        Scanner scanner = new Scanner(System.in);

        boolean closeMenu = false;

        do {
            System.out.println("-- CRUD REFORMED --\n");
            System.out.println("0 - Exit");
            System.out.println("1 - Insert Authors");
            System.out.println("2 - Search Authors by ID");
            System.out.println("3 - List Authors");
            System.out.println("4 - Update Authors");
            System.out.println("5 - Delete Authors");
            System.out.println("6 - Insert Books");
            System.out.println("7 - Search Books by ISBN");
            System.out.println("8 - List Books");
            System.out.println("9 - Update Books");
            System.out.println("10 - Delete Books");
            System.out.println("11 - Delete an Author from a Book");

            System.out.println("Select your option:");
            int op = Integer.parseInt(scanner.nextLine());

            switch (op) {
                case 0 -> {
                    System.out.println("Leaving...");
                    closeMenu = true;
                }

                case 1 -> {
                    System.out.println("-- Insert Authors--\n");

                    System.out.println("Inform the author's first name:");
                    String firstName = scanner.nextLine();

                    System.out.println("Inform the author's last name:");
                    String lastName = scanner.nextLine();

                    Author author = new Author(firstName, lastName);

                    if (authorDao.insert(author) > 0) {
                        System.out.println("Success!\n");
                    } else {
                        System.out.println("Failed!\n");
                    }
                    break;
                }

                case 2 -> {
                    System.out.println("-- Search Authors by ID --\n");

                    System.out.println("Inform the author's ID you wish to find:");
                    String temp = scanner.nextLine();
                    int id = Integer.parseInt(temp);

                    Author author = authorDao.read(id);

                    if (author != null) {
                        System.out.println("Author found!\n");
                        System.out.println("ID: " + author.getAuthorsId());
                        System.out.println("First name: " + author.getFirstName());
                        System.out.println("Last name: " + author.getLastName());
                        System.out.println("\n");

                        System.out.println("Do you wish to see his books? 1 - YES 2 - NO");
                        temp = scanner.nextLine();
                        int option = Integer.parseInt(temp);

                        if (option == 1) {
                            ArrayList<Title> titlesList = authorTitleDAO.buscarTitlesPorAuthor(id);
                            for (Title title : titlesList) {
                                System.out.println("ISBN: " + title.getISBN());
                                System.out.println("Title: " + title.getTitle());
                                System.out.println("Edition number: " + title.getEditionNumber());
                                System.out.println("Copyright: " + title.getCopyright());
                                System.out.println("\n");
                            }
                        }
                    } else {
                        System.out.println("Couldn't find any authors with the ID: " + id);
                    }
                    break;
                }

                case 3 -> {
                    System.out.println("-- List Authors --\n");

                    ArrayList<Author> authorList = authorDao.list();

                    for (Author author : authorList) {
                        System.out.println("ID: " + author.getAuthorsId());
                        System.out.println("First name: " + author.getFirstName());
                        System.out.println("Last name: " + author.getLastName());
                        System.out.println();
                        System.out.println("\n");
                    }
                    break;
                }

                case 4 -> {
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

                case 5 -> {
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

                case 6 -> {
                    System.out.println("-- Insert Books --\n");

                    System.out.println("Inform the book's ISBN:");
                    int isbn = Integer.parseInt(scanner.nextLine());

                    System.out.println("Inform the book's title:");
                    String title = scanner.nextLine();

                    System.out.println("Inform the book's edition:");
                    String edition = scanner.nextLine();

                    System.out.println("Inform the book's copyright:");
                    String copyright = scanner.nextLine();

                    Title book = new Title(isbn, title, edition, copyright);

                    if (titleDao.insert(book) > 0) {
                        System.out.println("How many authors does the book have?");
                        String temp = scanner.nextLine();
                        int qtyAut = Integer.parseInt(temp);

                        for (int i = 1; i <= qtyAut; i++) {
                            System.out.println("Inform the author's ID:");
                            temp = scanner.nextLine();
                            int idAut = Integer.parseInt(temp);
                            authorTitleDAO.associarAutorLivro(idAut, isbn);
                        }

                        System.out.println("Success!\n");
                    } else {
                        System.out.println("Failed!\n");
                    }
                    break;
                }

                case 7 -> {
                    System.out.println("-- Search Books by ISBN --\n");

                    System.out.println("Inform the book's ISBN you wish to find:");
                    String temp = scanner.nextLine();
                    int isbn = Integer.parseInt(temp);

                    Title title = titleDao.read(isbn);

                    if (title != null) {
                        System.out.println("Book found!\n");
                        System.out.println("ISBN: " + title.getISBN());
                        System.out.println("Title: " + title.getTitle());
                        System.out.println("Edition Number: " + title.getEditionNumber());
                        System.out.println("Copyright: " + title.getCopyright());
                        System.out.println("\n");

                        System.out.println("Do you wish to see the author(s) from this book? 1 - YES 2 - NO");
                        temp = scanner.nextLine();
                        int option = Integer.parseInt(temp);

                        if (option == 1) {
                            ArrayList<Author> authorList = authorTitleDAO.buscarAuthorsPorTitle(isbn);

                            for (Author author : authorList) {
                                System.out.println("ID: " + author.getAuthorsId());
                                System.out.println("First name: " + author.getFirstName());
                                System.out.println("Last name: " + author.getLastName());
                                System.out.println("\n");
                            }
                        }
                    } else {
                        System.out.println("Couldn't find any books with the ID: " + isbn);
                    }
                    break;
                }

                case 8 -> {
                    System.out.println("-- List Books --\n");

                    ArrayList<Title> titleList = titleDao.list();

                    for (Title title : titleList) {
                        System.out.println("ISBN: " + title.getISBN());
                        System.out.println("Title: " + title.getTitle());
                        System.out.println("Edition Number: " + title.getEditionNumber());
                        System.out.println("Copyright: " + title.getCopyright());
                        System.out.println("\n");
                    }
                    break;
                }

                case 9 -> {
                    System.out.println("-- Update Books --\n");

                    System.out.println("Inform the book's ISBN you wish to update:");
                    String temp = scanner.nextLine();
                    int id = Integer.parseInt(temp);

                    Title book = titleDao.read(id);

                    if (book == null) {
                        System.out.println("Couldn't find any books!\n");
                    } else {
                        System.out.println("Do you wish to change the book's title? 1 - YES 2 - NO");
                        temp = scanner.nextLine();
                        int firstAnswer = Integer.parseInt(temp);

                        if (firstAnswer == 1) {
                            System.out.println("Inform the new title:");
                            String title = scanner.nextLine();
                            book.setTitle(title);
                        }

                        System.out.println("Do you wish to change the book's edition number? 1 - YES 2 - NO");
                        temp = scanner.nextLine();
                        int secondAnswer = Integer.parseInt(temp);

                        if (secondAnswer == 1) {
                            System.out.println("Inform the new edition number:");
                            String edition = scanner.nextLine();
                            book.setEditionNumber(edition);
                        }

                        System.out.println("Do you wish to change the book's copyright? 1 - YES 2 - NO");
                        temp = scanner.nextLine();
                        int thirdAnswer = Integer.parseInt(temp);

                        if (thirdAnswer == 1) {
                            System.out.println("Inform the new copyright");
                            String copyright = scanner.nextLine();
                            book.setCopyright(copyright);
                        }

                        if (titleDao.update(book) > 0) {
                            System.out.println("Success!\n");
                        } else {
                            System.out.println("Nothing has been updated!\n");
                        }
                    }
                    break;
                }

                case 10 -> {
                    System.out.println("-- Delete Books --\n");

                    System.out.println("Inform the book's ISBN you wish to delete");
                    String temp = scanner.nextLine();
                    int isbn = Integer.parseInt(temp);

                    if (titleDao.delete(isbn) > 0) {
                        System.out.println("Success!\n");
                    } else {
                        System.out.println("Failed!\n");
                    }
                    break;
                }

                case 11 -> {
                    System.out.println("-- Delete Author from a Book --\n");

                    System.out.println("Inform the book's ISBN you wish to remove an author");
                    String temp = scanner.nextLine();
                    int isbn = Integer.parseInt(temp);

                    ArrayList<Author> authorList = authorTitleDAO.buscarAuthorsPorTitle(isbn);

                    System.out.println("-- Author's List --\n");
                    for (Author author : authorList) {
                        System.out.println("ID: " + author.getAuthorsId());
                        System.out.println("Author's first name: " + author.getFirstName());
                        System.out.println("Author's last name: " + author.getLastName());
                        System.out.println("\n");
                    }
                    System.out.println("How many authors do you wish to delete?");
                    temp = scanner.nextLine();
                    int qtyAut = Integer.parseInt(temp);

                    if (qtyAut > 0) {
                        for (int i = 1; i <= qtyAut; i++) {
                            System.out.println("Inform the author's ID you wish to remove");
                            temp = scanner.nextLine();
                            int autID = Integer.parseInt(temp);
                            authorTitleDAO.desassociarAutorLivro(autID, isbn);
                        }
                        System.out.println("Success!\n");
                    }
                    break;
                }
                default -> {
                    System.out.println("Invalid option!\n");
                }
            }
        } while (!closeMenu);
    }
}
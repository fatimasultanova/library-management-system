package az.div.utils;

import static az.div.utils.InputUtil.*;

public class MenuUtil {
    public static int mainMenu() {
        System.out.println("[1].Author\n" +
                "[2].Book\n" +
                "[3].Library\n" +
                "[0].Exit program\n");
        return inputInt("Enter option: ");
    }

    public static int authorMenu() {
        System.out.println("[1].Create author\n" +
                "[2].Get author by id\n" +
                "[3].Get all authors\n" +
                "[4].Update author\n" +
                "[5].Delete author\n" +
                "[6].Get all books by author" +
                "[0].Exit program\n");
        return inputInt("Enter option: ");
    }

    public static int bookMenu() {
        System.out.println("[1].Create book\n" +
                "[2].Get book by id\n" +
                "[3].Get all books\n" +
                "[4].Update book\n" +
                "[5].Delete book\n" +
                "[6].Search books by title\n" +
                "[0].Exit program\n");
        return inputInt("Enter option: ");
    }
    public static int libraryMenu() {
        System.out.println("[1].Create library\n" +
                "[2].Get library by id\n" +
                "[3].Get all libraries\n" +
                "[4].Update library\n" +
                "[5].Delete library\n" +
                "[6].Add book to library" +
                "[0].Exit program\n");
        return inputInt("Enter option: ");
    }
}

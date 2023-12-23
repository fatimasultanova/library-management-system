package az.div.services.manageclasses;

import static az.div.manage.FillDetails.*;
import az.div.services.BookService;
import az.div.services.inter.BookServiceInter;

import static az.div.utils.InputUtil.inputLong;
import static az.div.utils.InputUtil.inputString;
import static az.div.utils.MenuUtil.*;

public class BookManage {
    BookServiceInter bookService = new BookService();
    public void manageBook() {
        while (true) {
            try {
                int option = bookMenu();
                switch (option) {
                    case 1:
                        bookService.createBook(createBook());
                        break;
                    case 2:
                        bookService.getBookById(inputLong("Enter id(for get): "));
                        break;
                    case 3:
                        bookService.getAllBooks();
                        break;
                    case 4:
                        bookService.updateBook(inputLong("Enter id(for update): "),createBook());
                        break;
                    case 5:
                        bookService.deleteBookById(inputLong("Enter id(for delete): "));
                        break;
                    case 6:
                        bookService.searchBooksByTitle(inputString("Enter title: "));
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid option!");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}

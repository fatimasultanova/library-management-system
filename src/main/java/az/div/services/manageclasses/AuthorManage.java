package az.div.services.manageclasses;

import static az.div.manage.FillDetails.*;

import az.div.services.AuthorService;
import az.div.services.inter.AuthorServiceInter;
import static az.div.utils.InputUtil.*;

import static az.div.utils.MenuUtil.*;

public class AuthorManage {
       AuthorServiceInter authorService = new AuthorService();
    public void manageAuthor() {
        while (true) {
            try {
                int option = authorMenu();
                switch (option) {
                    case 1:
                        System.out.println(authorService.createAuthor(createAuthor()));
                        break;
                    case 2:
                        System.out.println(authorService.getAuthorById(inputLong("Enter id(for get): ")));
                        break;
                    case 3:
                        System.out.println(authorService.getAllAuthors());
                        break;
                    case 4:
                        System.out.println(authorService.updateAuthor(inputLong("Enter id(for update): "), createAuthor()));
                        break;
                    case 5:
                        authorService.deleteAuthorById(inputLong("Enter id(for delete): "));
                        break;
                    case 6:
                        System.out.println(authorService.getAllBooksByAuthor(inputLong("Enter author id(for all books): ")));
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid option!");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

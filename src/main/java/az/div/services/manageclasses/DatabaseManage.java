package az.div.services.manageclasses;

import static az.div.utils.MenuUtil.*;

public class DatabaseManage {

    AuthorManage authorManage = new AuthorManage();
    BookManage bookManage = new BookManage();
    LibraryManage libraryManage = new LibraryManage();
    public void manageDatabase() {
        while (true) {
            try {
                int entryOption = mainMenu();
                switch (entryOption) {
                    case 1:
                        authorManage.manageAuthor();
                        break;
                    case 2:
                        bookManage.manageBook();
                        break;
                    case 3:
                        libraryManage.manageLibrary();
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

    }}

package az.div.services.manageclasses;

import static az.div.manage.FillDetails.*;
import az.div.services.LibraryService;
import az.div.services.inter.LibraryServiceInter;

import static az.div.utils.InputUtil.inputLong;
import static az.div.utils.MenuUtil.*;

public class LibraryManage {

LibraryServiceInter libraryService = new LibraryService();
    public void manageLibrary() {
        while (true) {
            int option = libraryMenu();
            switch (option) {
                case 1:
                    libraryService.createLibrary(createLibrary());
                    break;
                case 2:
                    libraryService.getLibraryById(inputLong("Enter id(for get): "));
                    break;
                case 3:
                    libraryService.getAllLibraries();
                    break;
                case 4:
                    libraryService.updateLibrary(inputLong("Enter id(for update): "), createLibrary());
                    break;
                case 5:
                    libraryService.deleteLibraryById(inputLong("Enter id(for delete): "));
                    break;
                case 6:
//                    Long libraryId = inputRequiredLong("Insert library id");
//                    Long bookId = inputRequiredLong("Insert book id");
//                    int numberOfCopies = inputRequiredInt("Insert number of copies of book: ");
                    //libraryService.addBookToLibrary(libraryId, bookId, numberOfCopies);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
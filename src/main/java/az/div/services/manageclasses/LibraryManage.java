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
                    System.out.println(libraryService.createLibrary(createLibrary()));
                    break;
                case 2:
                    System.out.println(libraryService.getLibraryById(inputLong("Enter id(for get): ")));
                    break;
                case 3:
                    System.out.println(libraryService.getAllLibraries());
                    break;
                case 4:
                    System.out.println(libraryService.updateLibrary(inputLong("Enter id(for update): "), createLibrary()));
                    break;
                case 5:
                    libraryService.deleteLibraryById(inputLong("Enter id(for delete): "));
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}

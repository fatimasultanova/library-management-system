package az.div.services.inter;

import az.div.entity.Book;
import az.div.entity.Library;

import java.util.List;

public interface LibraryServiceInter {
    Library createLibrary(Library library);
    Library getLibraryById(long id);
    List<Library> getAllLibraries();
    Library updateLibrary(long id,Library library);
    void deleteLibraryById(long id);
}

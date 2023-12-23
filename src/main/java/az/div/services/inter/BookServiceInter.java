package az.div.services.inter;

import az.div.entity.Author;
import az.div.entity.Book;

import java.util.List;

public interface BookServiceInter {
    Book createBook(Book book);
    Book getBookById(long id);
    List<Book> getAllBooks();
    Book updateBook(long id,Book book);
    void deleteBookById(long id);
    List<Book> searchBooksByTitle(String title);
    List<Author> getAuthorsOfBook(long id);
}

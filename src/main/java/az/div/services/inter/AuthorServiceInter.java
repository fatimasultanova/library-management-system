package az.div.services.inter;

import az.div.entity.Author;
import az.div.entity.Book;

import java.util.List;

public interface AuthorServiceInter {
    Author createAuthor(Author author);
    Author getAuthorById(long id);
    List<Author> getAllAuthors();
    Author updateAuthor(long id,Author author);
    void deleteAuthorById(long id);
    List<Book> getAllBooksByAuthor(long authorId);
}

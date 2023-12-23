package az.div.services;

import az.div.entity.Book;
import az.div.manage.EntityManage;
import az.div.services.inter.BookServiceInter;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BookService implements BookServiceInter {
    EntityManage entityManage = EntityManage.getInstance();

    @Override
    public Book createBook(Book book) {
        entityManage.getEntityTransaction().begin();
        try {
            entityManage.getEntityManager().persist(book);
            entityManage.getEntityTransaction().commit();
        }catch (Exception ex){
            entityManage.getEntityTransaction().rollback();
        }
        return book;

    }

    @Override
    public Book getBookById(long id) {
        TypedQuery<Book> bookQ = entityManage.getEntityManager().createQuery("select b from Book b where b.id = :id", Book.class);
        bookQ.setParameter("id",id);
        return bookQ.getSingleResult();
    }

    @Override
    public List<Book> getAllBooks() {
        TypedQuery<Book> bookQ = entityManage.getEntityManager().createQuery("select b from Book b", Book.class);
        return bookQ.getResultList();
    }


    // I must change
    @Override
    public Book updateBook(long id, Book book) {
        entityManage.getEntityTransaction().begin();

        try {
            Book book2 = entityManage.getEntityManager().find(Book.class, id);
            book2.setTitle(book.getTitle());
            book2.setISBN(book.getISBN());
            book2.setPublication_year(book.getPublication_year());
            book2.setDescription(book.getDescription());
            book2.setLanguage(book.getLanguage());
            book2.setAvailable_copies(book.getAvailable_copies());
            entityManage.getEntityTransaction().commit();
            return book2;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteBookById(long id) {
        entityManage.getEntityTransaction().begin();
        try {
            Book book = entityManage.getEntityManager().find(Book.class, id);
            if (book != null) {
                entityManage.getEntityManager().remove(book);
                entityManage.getEntityTransaction().commit();
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }

    }

    @Override
    public List<Book> searchBooksByTitle(String title) {
        TypedQuery<Book> bookQ = entityManage.getEntityManager().createQuery("select b from Book b where b.title = :title", Book.class);
        bookQ.setParameter("title",title);
        return bookQ.getResultList();
    }
}

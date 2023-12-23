package az.div.services;

import az.div.entity.Author;
import az.div.entity.Book;
import az.div.manage.EntityManage;
import az.div.services.inter.AuthorServiceInter;
import jakarta.persistence.TypedQuery;


import java.util.List;

public class AuthorService implements AuthorServiceInter {
    EntityManage entityManage = EntityManage.getInstance();

    @Override
    public Author createAuthor(Author author) {
        entityManage.getEntityTransaction().begin();
        try {
            entityManage.getEntityManager().persist(author);
            entityManage.getEntityTransaction().commit();
        }catch (Exception ex){
            entityManage.getEntityTransaction().rollback();
        }
        return author;
    }

    @Override
    public Author getAuthorById(long id) {
        TypedQuery<Author> authorQ = entityManage.getEntityManager().createQuery("select a from Author a where a.id = :id", Author.class);
        authorQ.setParameter("id",id);
       return authorQ.getSingleResult();
    }

    @Override
    public List<Author> getAllAuthors() {
        TypedQuery<Author> authorQ = entityManage.getEntityManager().createQuery("select a from Author a", Author.class);
        return authorQ.getResultList();
    }

    @Override
    public Author updateAuthor(long id, Author author) {
        entityManage.getEntityTransaction().begin();

        try {
            Author author2 = entityManage.getEntityManager().find(Author.class, id);
            author2.setName(author.getName());
            author2.setSurname(author.getSurname());
            author2.setBirth_date(author.getBirth_date());
            author2.setDeath_date(author.getDeath_date());
            author2.setNationality(author.getNationality());
            entityManage.getEntityTransaction().commit();
            return author2;
        }catch (Exception ex){
            ex.printStackTrace();
        }
              return null;
    }


    @Override
    public void deleteAuthorById(long id) {
        entityManage.getEntityTransaction().begin();

        try {
            Author author = entityManage.getEntityManager().find(Author.class, id);
            if (author != null) {
                entityManage.getEntityManager().remove(author);
                entityManage.getEntityTransaction().commit();
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllBooksByAuthor(long authorId) {
        TypedQuery<Book> authorQ = entityManage.getEntityManager().createQuery("select b from Book b join b.author a where a.id = :authorId", Book.class );
        authorQ.setParameter("authorId" , authorId);
        return authorQ.getResultList();
    }
}

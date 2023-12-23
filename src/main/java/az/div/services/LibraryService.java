package az.div.services;

import az.div.entity.Library;
import az.div.manage.EntityManage;
import az.div.services.inter.LibraryServiceInter;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LibraryService implements LibraryServiceInter {
    EntityManage entityManage = EntityManage.getInstance();

    @Override
    public Library createLibrary(Library library) {
        entityManage.getEntityTransaction().begin();
        try {
            entityManage.getEntityManager().persist(library);
            entityManage.getEntityTransaction().commit();
        }catch (Exception ex){
            entityManage.getEntityTransaction().rollback();
        }
        return library;
    }

    @Override
    public Library getLibraryById(long id) {
        TypedQuery<Library> libraryQ = entityManage.getEntityManager().createQuery("select l from Library l where l.id = :id", Library.class);
        libraryQ.setParameter("id",id);
        return libraryQ.getSingleResult();
    }

    @Override
    public List<Library> getAllLibraries() {
        TypedQuery<Library> libraryQ = entityManage.getEntityManager().createQuery("select l from Library l", Library.class);
        return libraryQ.getResultList();
    }

    @Override
    public Library updateLibrary(long id, Library library) {
        entityManage.getEntityTransaction().begin();

        try {
            Library library2 = entityManage.getEntityManager().find(Library.class, id);
            library2.setName(library.getName());
            library2.setAddress(library.getAddress());
            library2.setContact(library.getContact());
            entityManage.getEntityTransaction().commit();
            return library2;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteLibraryById(long id) {
        entityManage.getEntityTransaction().begin();
        try {
            Library library = entityManage.getEntityManager().find(Library.class, id);
            if (library != null) {
                entityManage.getEntityManager().remove(library);
                entityManage.getEntityTransaction().commit();
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }

    }
}

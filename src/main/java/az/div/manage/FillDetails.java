package az.div.manage;

import az.div.entity.Author;
import az.div.entity.Book;
import az.div.entity.Library;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FillDetails {
    public static Scanner scanner =  new Scanner(System.in);


    public static Author createAuthor (){
        System.out.println("Name: ");
        String name =scanner.nextLine();
        System.out.println("Surname: ");
        String surname = scanner.nextLine();
        System.out.println("Birth date: ");
        String birth = scanner.nextLine();
        System.out.println("Death date: ");
        String death = scanner.nextLine();
        System.out.println("Nationality: ");
        String nationality = scanner.nextLine();
        Author author = new Author(name,surname,birth,death,nationality);
        return author;
    }

    public static Book createBook(){
        System.out.println("Title: ");
        String title =scanner.nextLine();
        System.out.println("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.println("Publication year: ");
        String publication = scanner.nextLine();
        System.out.println("Description: ");
        String description = scanner.nextLine();
        System.out.println("Language: ");
        String language = scanner.nextLine();
        System.out.println("Available copies: ");
        int available_copies = scanner.nextInt();
        System.out.println("Library id: ");
        long id = scanner.nextLong();
        TypedQuery<Library> libraryTypedQuery = EntityManage.getInstance().getEntityManager().createQuery("select l from Library l where l.id=:id", Library.class);
        libraryTypedQuery.setParameter("id",id);
        System.out.println("Enter author count: ");
        int n = scanner.nextInt();
        List<Author> authorList = getList(n);
        Book book = new Book(title,isbn,publication,description,language,available_copies,libraryTypedQuery.getSingleResult(),authorList);
        return book;
    }

    private static List<Author> getList(int n) {
        List<Author> authorList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Author id: ");
            long id = scanner.nextLong();
            TypedQuery<Author> authorTypedQuery = EntityManage.getInstance().getEntityManager().createQuery("select a from Author a where a.id=:id", Author.class);
            authorTypedQuery.setParameter("id", id);
            authorList.add(authorTypedQuery.getSingleResult());
        }
        return authorList;
    }


    public static Library createLibrary (){
        System.out.println("Name: ");
        String name =scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("Contact: ");
        String contact = scanner.nextLine();
        Library library = new Library(name,address,contact);
        return library;
    }


}

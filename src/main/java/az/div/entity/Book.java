package az.div.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books" , schema = "library_data")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,updatable = true)
    private String title;
    @Column(name = "isbn",nullable = false,unique = true)
    private String ISBN;
    private String publication_year;
    private String description;
    private String language;
    private int available_copies;
    @ManyToOne(cascade = {CascadeType.REMOVE,CascadeType.MERGE})
    @JoinColumn(name = "library_id")
    private Library library;
    @ManyToMany
    @JoinColumn(name = "author_id")
    @JoinTable(schema = "library_data",
            name = "books_authors",
            joinColumns = @JoinColumn(
                    name = "books_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "authors_id", referencedColumnName = "id"
            ))
    private List<Author> author;

    public Book(String title, String ISBN, String publication_year, String description, String language, int available_copies) {
        this.title = title;
        this.ISBN = ISBN;
        this.publication_year = publication_year;
        this.description = description;
        this.language = language;
        this.available_copies = available_copies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", publication_year='" + publication_year + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", available_copies=" + available_copies +
                '}';
    }

    public Book() {
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getAvailable_copies() {
        return available_copies;
    }

    public void setAvailable_copies(int available_copies) {
        this.available_copies = available_copies;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}

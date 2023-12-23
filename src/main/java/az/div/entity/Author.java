package az.div.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Author")
@Table(name = "authors" , schema = "library_data")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,updatable = true)
    private String name;
    @Column(nullable = false,updatable = true)
    private String surname;
    @Column(nullable = false,updatable = true)
    private String birth_date;
    @Column(updatable = true)
    private String death_date;
    @Column(nullable = false,updatable = true)
    private String nationality;
    @ManyToMany(mappedBy = "author", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Book> books;

    public Author(String name, String surname, String birth_date, String death_date, String nationality) {
        this.name = name;
        this.surname = surname;
        this.birth_date = birth_date;
        this.death_date = death_date;
        this.nationality = nationality;
    }

    public Author(){

    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birth_date=" + birth_date +
                ", death_date=" + death_date +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getDeath_date() {
        return death_date;
    }

    public void setDeath_date(String death_date) {
        this.death_date = death_date;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}

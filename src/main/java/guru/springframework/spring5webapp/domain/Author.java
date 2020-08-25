package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author {
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Author() {}

    public Author(String first, String last, Set<Book> books) {
        this.firstName = first;
        this.lastName = last;
        this.books = books;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                ", id=" + id +
                '}';
    }
}

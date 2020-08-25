package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book {
    private String title;
    private String ibsn;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public Book() {}

    public Book(String title, String ibsn, Set<Author> authors) {
        this.title = title;
        this.ibsn = ibsn;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIbsn() {
        return ibsn;
    }

    public void setIbsn(String ibsn) {
        this.ibsn = ibsn;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
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
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", ibsn='" + ibsn + '\'' +
                ", authors=" + authors +
                ", id=" + id +
                '}';
    }
}

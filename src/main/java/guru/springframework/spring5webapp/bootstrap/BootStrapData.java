package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
Spring manager component
*/
@Component
public class BootStrapData implements CommandLineRunner {
    // Sprng does dependency injection
    // into the constructors for the below instances
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    // Under the hood Spring data JPA is utilizing
    // Hibernate to save data to memory H2
    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher sfg = new Publisher();
        sfg.setName("SFG Publishing");
        sfg.setCity("St. Petersburg");
        sfg.setState("FL");

        publisherRepository.save(sfg);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "23");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(sfg);
        sfg.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(sfg);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EEE Development without", "123123");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(sfg);
        sfg.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(sfg);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("SFG Number of Books: " + sfg.getBooks().size());

    }
}

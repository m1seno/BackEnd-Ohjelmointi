package k25.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k25.bookstore.domain.Book;
import k25.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repository) {
		return (args) -> {
			log.info("save some books");
			repository.save(new Book("1984", "George Orwell", "9789510505830", 1949, 26.30));
			repository.save(new Book("Crime and Punishment", "Fyodor Dostoyevsky", "9780140449136", 1866, 25.10));
			repository.save(new Book("The Brothers Karmazov", "Fyodor Dostoyevsky", "9780140449242", 1880, 24.20));
			repository.save(new Book("All the Light We Cannot See", "Anthony Doerr", "9780007548699", 2015, 25.00));
			repository.save(new Book("The Coddling of the American Mind", "Jonathan Haidt", "9780735224896", 2018, 27.50));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
			log.info("fetch by author");
			for (Book book : repository.findByAuthor("Fyodor Dostoyevsky")) {
				log.info(book.toString());
			}

		};
	}

}

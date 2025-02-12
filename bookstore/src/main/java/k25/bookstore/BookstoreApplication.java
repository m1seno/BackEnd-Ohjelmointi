package k25.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import k25.bookstore.domain.Book;
import k25.bookstore.domain.BookRepository;
import k25.bookstore.domain.Category;
import k25.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository bRepository, CategoryRepository cRepository) {
		return (args) -> {
			log.info("save some books");

			Category category1 = new Category("Fiction");
			Category category2 = new Category("War");
			Category category3 = new Category("Psychology");
			Category category4 = new Category("History");
			Category category5 = new Category("Science");
			Category category6 = new Category("Biography");

			cRepository.save(category1);
			cRepository.save(category2);
			cRepository.save(category3);
			cRepository.save(category4);
			cRepository.save(category5);
			cRepository.save(category6);

			bRepository.save(new Book("1984", "George Orwell", "9789510505830", 1949, 26.30, category1));
			bRepository.save(new Book("Crime and Punishment", "Fyodor Dostoyevsky", "9780140449136", 1866, 25.10, category1));
			bRepository.save(new Book("The Brothers Karmazov", "Fyodor Dostoyevsky", "9780140449242", 1880, 24.20, category1));
			bRepository.save(new Book("All the Light We Cannot See", "Anthony Doerr", "9780007548699", 2015, 25.00, category1));
			bRepository.save(new Book("The Coddling of the American Mind", "Jonathan Haidt", "9780735224896", 2018, 27.50, category3));
			bRepository.save(new Book("Tuntematon Sotilas", "Väinö Linna", "2345098756785", 1954, 31.90, category2));

			log.info("fetch all books");
			for (Book book : bRepository.findAll()) {
				log.info(book.toString());
			}

			log.info("fetch by author");
			for (Book book : bRepository.findByAuthor("Fyodor Dostoyevsky")) {
				log.info(book.toString());
			}

		};
	}

}

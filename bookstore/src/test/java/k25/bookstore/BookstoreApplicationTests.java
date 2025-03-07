package k25.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import k25.bookstore.domain.BookRepository;

@SpringBootTest
class BookstoreApplicationTests {
	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testDatabaseConnection() {
		assertThat(bookRepository).isNotNull();
		assertThat(bookRepository.count()).isNotNull();
	}

}

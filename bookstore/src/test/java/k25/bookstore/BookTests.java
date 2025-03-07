package k25.bookstore;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import k25.bookstore.domain.Book;
import k25.bookstore.domain.BookRepository;
import k25.bookstore.domain.Category;
import k25.bookstore.domain.CategoryRepository;

@DataJpaTest
public class BookTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void shouldReturnAtLeastOneBook() throws Exception {
        assertThat(bookRepository.count()).isGreaterThan(0);
    }

    @Test
    public void saveNewBook() throws Exception {
        Category category = new Category("Fiction");
        categoryRepository.save(category);
        Book book = new Book("1984", "George Orwell", "9789510505830", 1949, 26.30, category);
        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void getCorrectData() {
        Optional<Book> book = bookRepository.findById((long) 1);
        assertThat(book).isPresent();
        assertThat(book.get().getAuthor()).isEqualTo("George Orwell");
        assertThat(book.get().getTitle()).isEqualTo("1984");
        assertThat(book.get().getIsbn()).isEqualTo("9789510505830");
        assertThat(book.get().getPublicationYear()).isEqualTo(1949);
        assertThat(book.get().getPrice()).isEqualTo(26.30);
        assertThat(book.get().getCategory().getName()).isEqualTo("Fiction");
    }

    @Test
    public void deleteBook() {
        List<Book> books = bookRepository.findByAuthor("Väinö Linna");
        Book book = books.get(0);
        bookRepository.delete(book);
        List<Book> newBooks = bookRepository.findByAuthor("Väinö Linna");
        assertThat(newBooks).hasSize(0);        
    }

}

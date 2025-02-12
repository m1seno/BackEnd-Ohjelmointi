package k25.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import k25.bookstore.domain.Book;
import k25.bookstore.domain.BookRepository;



@RestController
public class BookRestController {

    @Autowired
    private BookRepository bRepository;

    @GetMapping("bookrest")
    public List<Book> bookList(){
        return (List<Book>) bRepository.findAll();
    }

    @GetMapping("bookrest/{id}")
    public Optional<Book> findBook(@PathVariable Long id){
        return bRepository.findById(id);
    }

    @PostMapping("bookrest")
    public Book saveNewBook(@RequestBody Book book) {        
        return bRepository.save(book);
    }

    @PutMapping("bookrest/{id}")
    public Book editBook(@RequestBody Book editedBook, @PathVariable Long id){
        editedBook.setId(id);
        return bRepository.save(editedBook);
    }

    @DeleteMapping("bookrest/{id}")
    public Iterable<Book> deleteBook(@PathVariable Long id){
        bRepository.deleteById(id);
        return bRepository.findAll();
    }
    
    

}

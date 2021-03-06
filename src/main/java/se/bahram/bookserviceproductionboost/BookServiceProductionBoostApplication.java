package se.bahram.bookserviceproductionboost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class BookServiceProductionBoostApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceProductionBoostApplication.class, args);
    }
}

record Book(@Id Long id, String title){}

interface BookRepository extends CrudRepository<Book, Long>{}

@RestController
@RequestMapping("/books")
class BookController{
    private final BookRepository bookRepository;


    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    Iterable<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @PostMapping
    Book addNewBook(@RequestBody Book book) {
        return this.bookRepository.save(book);
    }
}
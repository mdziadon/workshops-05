package pl.coderslab.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private MemoryBookService bookService;

    public BookController(MemoryBookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

/*
    Przekazujemy przez Postman:

    {"id":10,
    "isbn":"9788324631766",
    "title":"Thinking in Java",
    "author":"Bruce Eckel",
    "publisher":"Helion",
    "type":"programming"}
*/

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

}

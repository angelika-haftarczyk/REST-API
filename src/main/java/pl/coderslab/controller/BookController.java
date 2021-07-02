package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private MockBookService mockBookService;

    @RequestMapping(value = "/helloBook", method = RequestMethod.GET)
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }


    @GetMapping(value = "")
    public List<Book> getBooks(){
        return mockBookService.getBooks();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        mockBookService.add(book);
    }



}

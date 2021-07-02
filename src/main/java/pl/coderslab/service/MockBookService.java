package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockBookService {

    private List<Book> books;
    private static Long nextId = 1L;

    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(nextId++, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(nextId++, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(nextId++, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }
}

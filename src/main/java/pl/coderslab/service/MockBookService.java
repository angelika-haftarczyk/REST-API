package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockBookService implements BookService {

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

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void add(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    @Override
    public Book getBook(Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Book book) {
        Book savedBook = getBook(book.getId());
        if(savedBook != null) {
            savedBook.setAuthor(book.getAuthor());
            savedBook.setIsbn(book.getIsbn());
            savedBook.setPublisher(book.getPublisher());
            savedBook.setTitle(book.getTitle());
            savedBook.setType(book.getType());
        }
    }


}

package org.example.booksmanagementsystem;


import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 10:31
 */
public class BookService {
    private List<Book> books;

    public BookService() {
        this.books = new ArrayList<Book>();
    }
    public List<Book> getBooks() {
        return books;
    }

    public void mock() {
        int size = 10;
        for (int i = 0; i < size; i++) {
            Book book = new Book();
            book.setBookName("Book " + i);
            book.setAuthor("Author " + i);
            book.setId(i);
            book.setCount(i+10+2);
            book.setPrice(BigDecimal.valueOf(Math.random()*100+1));
            book.setPublish("Publish " + i);
            book.setStatus(i%2);
            books.add(book);
        }
    }

}

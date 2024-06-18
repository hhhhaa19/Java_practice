package org.example.booksmanagementsystem.dao;

import org.example.booksmanagementsystem.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 13:05
 */
@Component
public class BookDao {
    public List<Book> mock() {
        List<Book> books = new ArrayList<Book>();
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
        return books;
    }
}

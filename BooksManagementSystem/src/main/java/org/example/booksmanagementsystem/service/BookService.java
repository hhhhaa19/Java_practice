package org.example.booksmanagementsystem.service;



import org.apache.ibatis.annotations.Delete;
import org.example.booksmanagementsystem.component.PageInfo;
import org.example.booksmanagementsystem.component.ReturnType;
import org.example.booksmanagementsystem.mapper.BookMapper;
import org.example.booksmanagementsystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 10:31
 */
@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;


    public String addBook(Book book) {
        Integer i = bookMapper.InsertBook(book);
        if(i>0){
            return "success";
        }
        return "fail";
    }

    public ReturnType<List<Book>,Integer> getAllBooksByPageInfo(PageInfo pageInfo) {
        List<Book> books = bookMapper.getAllBooksByPageInfo(pageInfo);
        Integer bookNumber = bookMapper.getBookNumber();
        return new ReturnType<List<Book>,Integer>(books,bookNumber);
    }
}

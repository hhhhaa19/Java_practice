package org.example.booksmanagementsystem.service;


import org.apache.ibatis.annotations.Delete;
import org.example.booksmanagementsystem.Enum.BookStatus;
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
        if (i > 0) {
            return "success";
        }
        return "fail";
    }

    public ReturnType<List<Book>, PageInfo> getAllBooksByPageInfo(PageInfo pageInfo) {
        List<Book> books = bookMapper.getAllBooksByPageInfo(pageInfo);
        for (Book book : books) {
            //可以用枚举类
            book.setStatusCH(BookStatus.getDescByValue(book.getStatus()));
        }
        Integer bookNumber = bookMapper.getBookNumber();
        pageInfo.setTotalRecords(bookNumber);
        return new ReturnType<List<Book>, PageInfo>(books, pageInfo);
    }
}

package org.example.booksmanagementsystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.booksmanagementsystem.component.PageInfo;
import org.example.booksmanagementsystem.model.Book;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-21
 * Time: 10:32
 */
@Mapper
public interface BookMapper {
    @Insert("insert into book_info (book_name,author,count,price,publish,status) values (#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer InsertBook(Book book);
    @Select("select count(1) from book_info ")
    Integer getBookNumber();
    @Select("select * from book_info limit #{offset},#{pageSize}")
    List<Book> getAllBooksByPageInfo(PageInfo pageInfo);
}

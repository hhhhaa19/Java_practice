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
    @Insert("insert into book_info (book_name,author,count,price,publish,status) " +
            "values (#{bookName},#{author},#{count},#{price},#{publish},#{status})")
    Integer InsertBook(Book book);

    @Select("select count(1) from book_info " +
            "where status != 0")//筛选未删除的
    Integer getBookNumber();

    @Select("select * from book_info where status != 0 " +
            "limit #{offset},#{pageSize} ") //排序
    List<Book> getAllBooksByPageInfo(PageInfo pageInfo);
    @Select("select * from book_info where id = #{bookId} and" +
            "  status != 0")
    Book selectBookById(Integer bookId);

    Integer updateBook(Book book);

    Integer updateBookByIds(List<Integer> bookIds);
}

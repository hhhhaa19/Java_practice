package book.comparator;

import book.Book;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-14
 * Time: 20:12
 */
public interface Mycomparator extends Comparator<Book> {
    @Override
    int compare(Book o1, Book o2);
}

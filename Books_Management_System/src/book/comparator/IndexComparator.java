package book.comparator;

import book.Book;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-14
 * Time: 20:08
 */
public class IndexComparator implements Mycomparator {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getIndex().compareTo(o2.getIndex());
    }
}

package book.comparator;

import book.Book;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-14
 * Time: 19:33
 */
public class PriceComparator implements Mycomparator {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPrice()-o2.getPrice();
    }
}

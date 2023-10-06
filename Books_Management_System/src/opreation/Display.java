package opreation;

import book.Booklist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 19:06
 */
public class Display implements Iopreation{
    @Override
    public void operation(Booklist booklist) {

        for (int i = 0; i < booklist.getUsed(); i++) {
            System.out.println(booklist.getBooks(i));
        }
    }
}

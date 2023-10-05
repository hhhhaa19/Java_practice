package opreation;

import book.Booklist;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 19:07
 */
public class Rent implements Iopreation {
    @Override
    public void operation(Booklist booklist) {
        System.out.println("归还图书");
    }
}

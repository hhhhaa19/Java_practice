package user;

import book.Booklist;
import opreation.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 19:20
 */
public abstract class User {

    protected Iopreation[] iopreations;
    public abstract void work(int choice,Booklist booklist);
    public abstract int menu();
}

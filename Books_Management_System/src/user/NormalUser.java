package user;

import book.Booklist;
import opreation.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 19:13
 */
public class NormalUser extends User {
    public NormalUser() {
        super.iopreations = new Iopreation[]{
                new Exit(),
                new Search(),
                new Borrow(),
                new Rent()
        };

    }

    @Override
    public void work(int choice, Booklist booklist) {
        iopreations[choice].operation(booklist);
    }

    @Override
    public int menu() {
        System.out.println("****普通人菜单****");
        System.out.println("****1.查找图书****");
        System.out.println("****2.借阅图书****");
        System.out.println("****3.归还图书****");
        System.out.println("****0.退出系统****");
        System.out.println("****************");
        System.out.println("***请输入你的操作**");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }
}
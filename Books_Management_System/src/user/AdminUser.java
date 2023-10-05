package user;

import book.Booklist;
import opreation.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 19:18
 */
public class AdminUser extends User {

    public AdminUser() {
        super.iopreations = new Iopreation[]{
                new Exit(),
                new Search(),
                new Add(),
                new Del(),
                new Display(),
        };
    }

    @Override
    public void work(int choice, Booklist booklist) {
        iopreations[choice].operation(booklist);
    }

    @Override
   public int menu() {
        System.out.println("****管理员菜单****");
        System.out.println("****1.查找图书****");
        System.out.println("****2.新增图书****");
        System.out.println("****3.删除图书****");
        System.out.println("****4.显示图书****");
        System.out.println("****0.退出系统****");
        System.out.println("****************");
        System.out.println("***请输入你的操作**");
        Scanner sc =new Scanner(System.in);
        int choice =sc.nextInt();
        return choice;
    }
}

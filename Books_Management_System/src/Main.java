import book.Booklist;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 19:19
 */
public class Main {
    public static User login() {
        System.out.println("请输入你的身份:1->管理员   0->普通用户");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (1 == choice) {
            return new AdminUser();
        } else {
            return new NormalUser();
        }
    }

    public static void main(String[] args) {
        User user = login();
        Booklist booklist=new Booklist();
        while (true) {
            int choice =user.menu();
            user.work(choice,booklist);
        }
    }
}

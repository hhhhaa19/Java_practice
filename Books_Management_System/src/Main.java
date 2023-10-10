import book.Booklist;
import expection.PasswordException;
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
    public static User login() throws PasswordException {
        System.out.println("请输入你的身份:1->管理员   0->普通用户");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        if (1 == choice) {
            int count = 3;
            while (count != 0) {
                System.out.println("请输入管理员名称");
                String name = sc.nextLine();
                System.out.println("请输入管理员密码");
                String password = sc.nextLine();
                if (AdminUser.getName().equals(name) && AdminUser.getPassword().equals(password)) {
                    return new AdminUser();
                }
                System.out.println("密码或用户名错误，剩余次数" + count);
                count--;
            }
            throw new PasswordException("登录失败");
        } else {
            return new NormalUser();
        }
    }

    public static void main(String[] args)throws PasswordException {
        try {
            User user = login();
            Booklist booklist = new Booklist();
            while (true) {
                int choice = user.menu();
                user.work(choice, booklist);
            }
        } catch (PasswordException e) {
            System.out.println("登录失败");
        }
    }
}
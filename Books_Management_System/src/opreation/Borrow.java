package opreation;

import book.Booklist;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 19:07
 */
public class Borrow implements Iopreation{
    @Override
    public void operation(Booklist booklist) {

        System.out.println("借阅图书");
        System.out.println("请输入要借阅的书籍名称");
        Scanner sc =new Scanner(System.in);
        String target =sc.nextLine();
        for (int i = 0; i < booklist.getUsed(); i++) {
            if(target.equals(booklist.getBooks(i).getName())){
                System.out.println(booklist.getBooks(i)+"借阅成功");
                booklist.getBooks(i).setIsborrowed(true);
                return;
            }
        }
        System.out.println("未找到");
    }
}

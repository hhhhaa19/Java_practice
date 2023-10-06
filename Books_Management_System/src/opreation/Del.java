package opreation;

import book.Booklist;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 19:06
 */
public class Del implements Iopreation{
    @Override
    public void operation(Booklist booklist) {
        System.out.println("删除图书");
        System.out.println("请输入要删除的书籍名称");
        Scanner sc =new Scanner(System.in);
        String target =sc.nextLine();
        for (int i = 0; i < booklist.getUsed(); i++) {
            if(target.equals(booklist.getBooks(i).getName())){
                System.out.println(booklist.getBooks(i)+"删除成功");
                for (int j = i; j < booklist.getUsed()-1; j++) {
                    booklist.setBooks(i,booklist.getBooks(i+1));
                }
                booklist.setUsed(booklist.getUsed()-1);
                return;
            }
        }
        System.out.println("未找到");
    }
}

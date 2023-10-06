package opreation;

import book.Book;
import book.Booklist;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 19:05
 */
public class Add implements Iopreation {
    @Override
    public void operation(Booklist booklist) {
        System.out.println("新增图书");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入书的名字");
        String name = sc.nextLine();
        System.out.println("请输入书的作者");
        String author = sc.nextLine();
        System.out.println("请输入书的类型");
        String type = sc.nextLine();
        System.out.println("请输入书的价格");
        int price = sc.nextInt();
        if (booklist.getUsed() == booklist.getCapacity()) {
            System.out.println("已满无法加书");
        } else {
            Book book = new Book(name, author, price, type);
            booklist.setBooks(booklist.getUsed(),book);
            booklist.setUsed(booklist.getUsed()+1);//由于下标与数目的不完全统一，这里used表示为下一本书的下标
            System.out.println("新增成功");
        }
    }
}

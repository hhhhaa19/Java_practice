package opreation;

import book.Book;
import book.Booklist;
import book.comparator.IndexComparator;
import book.comparator.Mycomparator;
import book.comparator.PriceComparator;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-14
 * Time: 18:55
 */
public class Sort implements Iopreation {
    /**
     *
     */
/*    public void operation(Booklist booklist) {
        Book[] books=booklist.getBooks();
        for (int i = 0; i < booklist.getUsed()-1; i++) {
            for (int j = 0; j < booklist.getUsed()-i-1; j++) {
                PriceComparator pc = new PriceComparator();
                if(pc.compare(books[j],books[j+1])>0){
                    Book temp =books[j];
                    books[j]=books[j+1];
                    books[j+1]=temp;
                }
            }
        }
    }*/
    //这里的问题是如果不设定长度，那么会按照book[]的长度而不是used长度，就会出现空指针异常
 /*   public void operation(Booklist booklist){
        Arrays.sort(booklist.getBooks(),0,booklist.getUsed());
    }*/
    Mycomparator[] mc;

    public static int Menuforsort() {
        System.out.println("************");
        System.out.println("1:根据价格排序");
        System.out.println("2:根据书编号排序");
        System.out.println("************");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }

    public Sort() {
        this.mc = new Mycomparator[]{
                new PriceComparator(),
                new IndexComparator()
        };
    }

    public void operation(Booklist booklist) {
        int choice = Menuforsort();
        Arrays.sort(booklist.getBooks(),0,booklist.getUsed(),mc[choice-1]);
    }
}

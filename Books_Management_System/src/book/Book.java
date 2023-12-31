package book;

import javax.rmi.CORBA.Stub;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 15:03
 */
public class Book {
    //根据序列号排序
    private String name;
    private String author;
    private int price;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    private String type;
    private boolean isborrowed;
    private String index;

    public Book(String name, String author, int price, String type, String index) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
        this.index = index;
    }

    public Book(String name, String author, int price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsborrowed() {
        return isborrowed;
    }

    public void setIsborrowed(boolean isborrowed) {
        this.isborrowed = isborrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +" 序列号 "+index+'\''+
                ", " + (isborrowed == true ? "已被借出" : "未被借出") +
                '}';
    }
}

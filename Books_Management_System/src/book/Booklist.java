package book;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-05
 * Time: 18:59
 */
public class Booklist {
    private Book[] books;
    private int used;
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Booklist(){
        this.capacity=10;
        this.books=new Book[this.capacity];
        this.books[0]=new Book("三国演义","罗贯中",23,"小说");
        this.used=1;
    }

    public Book getBooks(int pos) {
        return books[pos];
    }

    public void setBooks(int pos,Book book) {
        this.books[pos]=book;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-18
 * Time: 19:22
 */
public class Test {
    public static void main1(String[] args) {
        MyLinklist ml = new MyLinklist();
        ml.addFirst(21);
        ml.addFirst(21);
        ml.addFirst(21);
        ml.addLast(21);
        ml.display();
        ml.removeAllKey(21);
        ml.addIndex(0,23);
        ml.display();

    }

    public static void main(String[] args) {
        MyLinkedlist ml = new MyLinkedlist();
        ml.addFirst(21);
        ml.addLast(54);
        ml.addIndex(1,67);
        ml.remove(67);
        ml.removeAllKey(21);
        ml.addIndex(0,23);
        ml.display();
        ml.clear();
    }
}

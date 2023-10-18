/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-18
 * Time: 19:22
 */
public class Test {
    public static void main(String[] args) {
        MySingleLinklist ml = new MySingleLinklist();
        ml.addFirst(21);
        ml.addFirst(21);
        ml.addFirst(21);
        ml.addLast(21);
        ml.display();
        ml.removeAllKey(21);
        ml.addIndex(0,23);
        ml.display();

    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-14
 * Time: 15:19
 */
public class test {
    public static void main2(String[] args) {
        Myarraylist ml =new Myarraylist();
        ml.add(23);
        ml.get(1);
    }
    public static void main(String[] args) {
        Myarraylist ml =new Myarraylist();
        ml.add(2);
        ml.add(1,23);
        ml.add(1,45);
        ml.display();
        System.out.println(ml.contains(23));
        System.out.println(ml.contains(1));
        System.out.println(ml.indexOf(2));
        System.out.println(ml.get(2));
        ml.set(0,66);
        ml.remove(23);
        ml.display();
        System.out.println(ml.size());
        ml.clear();
        ml.display();

    }
}

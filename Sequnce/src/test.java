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
    public static void main1(String[] args) {
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

    public static void main3(String[] args) {
        Myarraylist<Student> ml =new Myarraylist();
        Student st=new Student(12,"hh");
        ml.add(st);
        ml.add(1,new Student(34,"kk"));
        ml.display();
        System.out.println(ml.contains(st));
        //我们在这边埋下一个伏笔，我们究竟该怎么判断两个对象相等，这种方式合理吗
        System.out.println(ml.indexOf(st));
        System.out.println(ml.get(1));
        ml.set(1,st);
        ml.display();
        ml.remove(st);
        ml.display();
        System.out.println(ml.size());
        ml.clear();
        ml.display();
    }

    public static void main4(String[] args) {
        Student st=new Student(12,"hh");
        Student st2=new Student(12,"hj");
        Myarraylist<Student> ml =new Myarraylist();
        ml.add(st);
        ml.add(st2);
        ml.get(1).age=43;
        ml.get(0).name="pp";
        ml.display();
    }
}

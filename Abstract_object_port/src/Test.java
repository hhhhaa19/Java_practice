/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-09-27
 * Time: 20:34
 */
public class Test {
    public static void main1(String[] args) {
        Student st1=new Student("tao",10);
        Student st2=new Student("pao",20);
        Agecomparator ac =new Agecomparator();
        NameComparator nc =new NameComparator();
        System.out.println(nc.compare(st1, st2));
    }

    public static void main(String[] args) {
        Teacher tc1 = new Teacher("zhang", 45);
        Teacher tc2 = new Teacher("zhan", 44);
        System.out.println(tc1.compareTo(tc2));

    }
}

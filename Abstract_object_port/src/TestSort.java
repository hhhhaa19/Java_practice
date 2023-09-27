import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-09-27
 * Time: 20:47
 */
public class TestSort {
    public static void main1(String[] args) {
        Teacher[] tc = new Teacher[2];
        tc[0] = new Teacher("zhang", 45);
        tc[1] = new Teacher("zhan", 44);
        System.out.println("排序前：" + Arrays.toString(tc));
        Arrays.sort(tc);
        System.out.println("排序后：" + Arrays.toString(tc));

    }

    public static void main(String[] args) {
        Student[] st = new Student[2];
        st[0] = new Student("tao", 10);
        st[1] = new Student("pao", 20);
        System.out.println(Arrays.toString(st));
        Agecomparator ac=new Agecomparator();
        Arrays.sort(st,ac);
        System.out.println(Arrays.toString(st));
    }
}

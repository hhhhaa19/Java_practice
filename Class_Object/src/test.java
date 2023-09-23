import com.bit.www.Classroom;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-09-23
 * Time: 10:25
 */
public class test {
    public static void main1(String[] args) {
        Data num=new Data();
        Scanner sc =new Scanner(System.in);
        num.setX(sc.nextInt());
        num.setY(sc.nextInt());
        System.out.println(num.getX()+ num.getY());
        sc.close();
    }

    public static void main2(String[] args) {
        Student st1=new Student("Benjamin",20,"20513322");
        System.out.println(st1);
        Scanner sc =new Scanner(System.in);
        st1.setId(sc.nextLine());
        System.out.println(st1.getId());
        System.out.println(st1);
    }

    public static void main(String[] args) {
        Classroom room =new Classroom(20);
        Classroom.show();
    }
}

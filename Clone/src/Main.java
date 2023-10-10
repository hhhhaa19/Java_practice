/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-10
 * Time: 20:54
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        Student st =new Student("Benjamin",20);
        Student st2 =(Student) st.clone();
        System.out.println(st2);
    }
}

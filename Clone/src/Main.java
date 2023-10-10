/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-10
 * Time: 20:54
 */
public class Main {
    //浅拷贝
    public static void main1(String[] args) throws CloneNotSupportedException{
        Student st =new Student("Benjamin",20,new Money(12));
        Student st2 =(Student) st.clone();
        st.age=10;
        st.money.money=20;
        System.out.println("st "+st.age+st.money.money);
        System.out.println("st2 "+st2.age+st2.money.money);
    }
    //深拷贝
    public static void main(String[] args)throws CloneNotSupportedException {
        Student st =new Student("Benjamin",20,new Money(12));
        Student st2 =(Student) st.clone();
        st2.money=(Money) st.money.clone();
        st.age=10;
        st.money.money=20;
        System.out.println("st "+st.age+st.money.money);
        System.out.println("st2 "+st2.age+st2.money.money);
    }
}

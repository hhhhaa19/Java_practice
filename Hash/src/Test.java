/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-12-10
 * Time: 19:09
 */
public class Test {
    public static void main1(String[] args) {
        SetMapPractice.lackKeyboard("Kkll", "ll");
    }

    public static void main(String[] args) {
        Student st1= new Student("Benjamin",20);
        Student st2= new Student("1",40);
        Student st3= new Student("2",40);
        Student st4= new Student("3",40);
        Student st5= new Student("4",40);
        Student st6= new Student("5",30);
        HashBucket<Student,Integer> hashBucket= new HashBucket<>();
        hashBucket.put(st1,1);
        hashBucket.put(st2,1);
        hashBucket.put(st3,1);
        hashBucket.put(st4,1);
        hashBucket.put(st5,1);
        hashBucket.put(st6,1);
    }
}

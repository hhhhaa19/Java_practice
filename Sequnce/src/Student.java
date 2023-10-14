/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-14
 * Time: 18:09
 */
public class Student {
    int age;
    String name;

    public String Id;

    public Student(int age, String name, String id) {
        this.age = age;
        this.name = name;
        Id = id;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

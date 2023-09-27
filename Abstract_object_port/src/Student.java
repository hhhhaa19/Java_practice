/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-09-27
 * Time: 20:32
 */
public class Student {
    String name;
    int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

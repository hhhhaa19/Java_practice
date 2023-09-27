/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-09-27
 * Time: 20:43
 */
public class Teacher implements Comparable<Teacher>{
    String name;
    int age;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Teacher o) {
        return this.age-o.age;
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-09-23
 * Time: 10:43
 */
public class Student {
    public String name;
    int age;
    private String Id;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Student(String name, int age) {
        this(name,23,"2333");
    }

    public Student() {
        this("ben",23,"304");
    }

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.Id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Id='" + Id + '\'' +
                '}';
    }
}

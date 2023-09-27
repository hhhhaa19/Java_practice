import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-09-27
 * Time: 20:36
 */
public class Agecomparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.age-o1.age;
    }
}

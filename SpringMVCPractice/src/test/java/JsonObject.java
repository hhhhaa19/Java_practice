import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.springmvcpractice.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-05-26
 * Time: 21:15
 */
public class JsonObject {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        Person person = new Person(12,"benjamin",23);
        String json = mapper.writeValueAsString(person);
        System.out.println(json);
        Person person2 = mapper.readValue(json, Person.class);
        System.out.println(person2);
    }
    //对T的限制只能放在前面，对整个方法用到T的地方起到限制,而通配符的限制往往只在使用时
    public<T extends Comparator<T>> void printList(List<? extends Objects> list) {
        for (Object element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

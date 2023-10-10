import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-10
 * Time: 18:41
 */
public class Config {
    public static int getElement(int[] arr, int index) {
        if (null == arr) {
            throw new NullPointerException("数组为NULL");
        }
        if (index < 0 || index >= arr.length) {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        return arr[index];
    }
}

package FileOperation;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-29
 * Time: 13:23
 */
public class FileOperationDemo3 {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/aaa/bbb/IMissYou");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.getCanonicalFile());
        file.mkdirs();
    }

}

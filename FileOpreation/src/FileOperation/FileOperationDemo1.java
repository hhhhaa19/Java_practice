package FileOperation;

import java.io.*;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-28
 * Time: 21:22
 */
public class FileOperationDemo1 {

    public static void main(String[] args) throws IOException {
        File file = new File("./temp.txt");
        File file2 = new File("./src");
        System.out.println(file.getParent());
        System.out.println(file.getName());
        System.out.println(file2.getName());
        System.out.println(file.getPath());
        System.out.println(file2.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.isFile());
        System.out.println(file2.isFile());
    }


}

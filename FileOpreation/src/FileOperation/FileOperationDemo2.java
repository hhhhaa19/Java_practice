package FileOperation;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-29
 * Time: 13:22
 */
public class FileOperationDemo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/hello_world.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file.isDirectory());
        if(file.exists()){
            System.out.println(file.delete());
        }
    }


}

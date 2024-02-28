import java.io.*;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-28
 * Time: 21:22
 */
public class FileOperation {

    public static void main1(String[] args) throws IOException {
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

    public static void main2(String[] args) throws IOException {
        File file = new File("./src/hello_world.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file.isDirectory());
        if(file.exists()){
            System.out.println(file.delete());
        }
    }

    public static void main3(String[] args) throws IOException {
        File file = new File("./src/aaa/bbb/IMissYou");
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.getCanonicalFile());
        file.mkdirs();
    }
//对于重命名的理解->移动
    public static void main(String[] args) {
        File fileSrc = new File("./temp.c");
        System.out.println(fileSrc.isFile());
        System.out.println(fileSrc.isDirectory());
        File fileDest = new File("./src/aaa/bbb/IMissYou/hereIam.java");
        System.out.println(fileDest.isFile());
        System.out.println(fileDest.isDirectory());
        //文件位置的移动(同一盘下)其实只是一个重命名操作，从一个独一无二的地址签名到另一个
        //可以识别文本文件（可直接互转）与字符文件
        System.out.println(fileDest.renameTo(fileSrc));
    }
}

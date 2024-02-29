package FileOperation;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-29
 * Time: 13:23
 */
public class FileOperationDemo4 {
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

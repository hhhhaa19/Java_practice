package FileOperation;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description://在指定路径下找到所有文件名为temp.txt的文件
 * User: Benjamin
 * Date: 2024-02-28
 * Time: 21:58
 */
public class Search_folder {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的目标路径");
        String targetPath = scanner.nextLine();
        File fireTargetPath = new File(targetPath);
        System.out.println("请输入要查找的文件名");
        String targetFilename= scanner.nextLine();
        if(!fireTargetPath.isDirectory()){
            return ;
        }
        //查找
        ScanDir(fireTargetPath,targetFilename);
    }

    private static void ScanDir(File fireTargetPath, String targetFilename) throws IOException {
        File[] curFile = fireTargetPath.listFiles();
        for (File f: curFile) {
            if(f.isFile()){
                //比较名字是否相同
                if(f.getName().equals(targetFilename)){
                    System.out.println(f.getCanonicalPath());
                }
            }
            if(f.isDirectory()){
                ScanDir(f,targetFilename);
            }
        }
    }
}

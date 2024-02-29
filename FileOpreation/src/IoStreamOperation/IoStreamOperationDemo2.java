package IoStreamOperation;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-29
 * Time: 13:24
 */
public class IoStreamOperationDemo2 {
    /**
     * 在提供的目录中，找到文件，查讯是否包含指定文字，若有则把他们都拷贝在路径aaa下
     */
    public static void main(String[] args) {
        System.out.println("请输入要提供的目录");
        Scanner scanner = new Scanner(System.in);
        File targetDictionary = new File(scanner.nextLine());
        System.out.println("请输入目标文字");
        String targetString = scanner.nextLine();
        //在指定目录下查询
        if (!targetDictionary.isDirectory()) {
            System.out.println("指定目录不存在");
            return;
        }
        ScanDir(targetDictionary, targetString);
    }

    private static void ScanDir(File targetDictionary, String targetString) {
        //先判断是否为文件
        if (targetDictionary.isFile()) {
            //读取内容，判断是否包含目标文字,
            String[] tag = new String[1];
            if (ScanFile(targetDictionary, targetString,tag)) {
            //包含，那就复制
                Copy(tag[0]);
            }
            return;
        }
        for (File f:targetDictionary.listFiles()) {
            ScanDir(f,targetString);
        }
    }
    private static int count = 0;

    private static void Copy(String s) {
        StringBuffer filename = new StringBuffer("temp");
        filename.append(count);
        filename.append(".txt");
        File file = new File("./src/aaa/"+filename);
        try(Writer writer= new FileWriter(file)){
            writer.write(s);
        }catch (IOException e){
            e.printStackTrace();
        }
        count++;
    }

    private static boolean ScanFile(File targetDictionary, String targetString,String[] tagText) {
        char[] buffer = new char[1024];
        StringBuffer tag = new StringBuffer();
        try (Reader reader = new FileReader(targetDictionary)) {
            while(true){
                int len =reader.read(buffer);
                if(len ==-1){
                    break;
                }
                String str = new String(buffer);
                tag.append(str);
            }
            if(tag.indexOf(targetString)==-1){
                //没找到
                return false;
            }else {
                tagText[0] = new String(tag);
                System.out.println(targetDictionary.getCanonicalPath());
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

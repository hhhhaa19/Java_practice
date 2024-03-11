package lab4;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-11
 * Time: 14:46
 */
public class InputOutputDemo {
    public static void main(String[] args) throws IOException {
        File file =new File ("./src/input.txt");
        File outfile =new File ("./output.txt");
        if(!outfile.exists()){
            outfile.createNewFile();
        }
        //字符流
//        try(FileReader reader = new FileReader(file);
//        FileWriter writer = new FileWriter(outfile)){
//            int len = 0;
//            char[] buffer = new char[4];
//            StringBuffer stringBuffer = new StringBuffer();
//            while(true){
//                len = reader.read(buffer,0,4);
//                if(len==-1){
//                    break;
//                }
//                stringBuffer.append(new String(buffer,0,len));
//            }
//            String ret = new String(stringBuffer);
//            //输出
//            writer.write(ret);
//            writer.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //字节流
        try(FileInputStream inputStream = new FileInputStream(file);
        FileOutputStream outputStream = new FileOutputStream(outfile)){
            int len  = 0;
            StringBuffer stringBuffer = new StringBuffer();
            while(true){
                byte[] buffer = new byte[12];
                len = inputStream.read(buffer,0,12);
                if(len == -1){
                    break;
                }
                String temp = new String(buffer,0,len);
                stringBuffer.append(temp);
            }
            String ret = new String(stringBuffer);
            System.out.println(ret);
            //输出
            outputStream.write(ret.getBytes());
            outputStream.flush();
        }
    }
}

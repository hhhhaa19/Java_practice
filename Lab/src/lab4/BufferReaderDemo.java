package lab4;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-11
 * Time: 14:22
 */
public class BufferReaderDemo {
    public static void main(String[] args) throws IOException {
        //system.in是字节流，先把他转化成字符流
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        int num = 1;
        while (num != 0) {
            try {
                System.out.println("Enter an integer number:");
                String cur = bufferedReader.readLine();
                num = Integer.valueOf(cur);
                System.out.printf("The input integer number is %d\n", num);
            } catch (NumberFormatException e) {
                System.out.println("The input should be an integer.");
                //注意，scanner类型不匹配会直接抛异常，不读取，reader由于是把所有都当字符串读，所以肯定不在缓存区
                continue;
            }catch (IOException e) {
                e.printStackTrace();
                bufferedReader.close();
                inputStreamReader.close();
            }
        }

    }
}

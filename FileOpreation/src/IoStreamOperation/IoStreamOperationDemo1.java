package IoStreamOperation;
import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-29
 * Time: 12:15
 */
public class IoStreamOperationDemo1 {

    /**
     * 把一个文本文件的内容复制到另一个文本文件
     */
    public static void main(String[] args) throws IOException {
        File srcfile = new File("./IMissYou.txt");
        if (!srcfile.exists()) {
            return;
        }
        if (!srcfile.isFile()) {
            return;
        }
        File dictionary = new File("./src/aaa/bbb");
        System.out.println("目标目录创建" + dictionary.mkdirs());
        File destfile = new File("./src/aaa/bbb/IMissYou.txt");
        System.out.println("目标文件创建" + destfile.createNewFile());
        byte[] buffer = new byte[1024];
        try (InputStream inputStream = new FileInputStream(srcfile); OutputStream outputstream = new FileOutputStream(destfile)) {
            StringBuilder str = new StringBuilder();
            while(true){
                int len = inputStream.read(buffer);
                if(len == -1){
                    break;
                }
                //输出到目标文件
                outputstream.write(buffer,0,len);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

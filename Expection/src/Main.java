import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-10
 * Time: 18:54
 */
public class Main {
    public static void getElement (int[] arr, int index) throws IOException {
        System.out.println("jh");
        if(1==1) {
            throw new IOException("h");
        }//这边不处理，传递下去
        //或者这边直接用try catch 捕获
    }
    public static void main1(String[] args) {

        int [] arr={1,23,3};
        try {
            getElement(arr, 3);
        }catch (IOException e){
            System.out.println("hh");
        }
      /*  int [] arr={1,23,3};
        throw new IOException("y")*/;
    }

    public static void main(String[] args) throws MyException{
        try {
            Login.login("23","jj");
        }catch (MyException e){
            System.out.println("错误处理好了");
        }
    }
}

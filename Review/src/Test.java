/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2024-01-15
 * Time: 15:15
 */

public class Test {
    static int i = 0;

    public int aMethod() {
        i++;
        return i;
    }
    public void add(Byte b)
    {
        b = b++;
    }
    public void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
    public static void main(String args[]) {
       new Test().test();
    }

}



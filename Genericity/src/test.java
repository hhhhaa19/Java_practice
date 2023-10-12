/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-12
 * Time: 16:45
 */
public class test {
    public static void main(String[] args) {
        Genericity<Integer> arr = new Genericity<Integer>();
        arr.setArr(0,23);
        arr.setArr(1,24);
        System.out.println(arr.getValue(1));
    }
    public static void mai2(String[] args) {
        Myarray ma =new Myarray();
        ma.setval(1,"sb");
        ma.setval(0,23);
        System.out.println(ma.getval(0));
        String s =(String) ma.getval(1);
        System.out.println(s);
    }
    public static void main1(String[] args) {
        Integer i=Integer.valueOf(23);
        Integer ii=new Integer(23);
        Integer iii =10;
        int iv =0;
    }
}

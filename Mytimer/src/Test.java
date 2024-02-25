/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-24
 * Time: 19:06
 */
public class Test {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hh");
            }
        },3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("gg");
            }
        },1000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hg");
            }
        },5000);
    }
}

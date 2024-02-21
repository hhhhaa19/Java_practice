package Threaddemo3;

/**
 * Created with IntelliJ IDEA.
 * Description:线程中断
 * User: 王金涛
 * Date: 2024-02-21
 * Time: 12:21
 */
public class ThreadDemo3 {
    /**
     * 用isInterrupted 来终断
     *
     * @param args
     */
    public static void main1(String[] args) {
        Thread thread1 = new Thread(() -> {
            //获取当前线程实例,isInterrupted 返回true如果被中断了
            //好像while true 也能实现,那么为什么要使用Thread.currentThread().isInterrupted
            while (!Thread.currentThread().isInterrupted()) {
                try{
                    Thread.sleep(100);
                }catch (InterruptedException exception){
                    exception.printStackTrace();
                    System.out.println(Thread.currentThread().isInterrupted());
                }
                System.out.println("hello Thread");
            }
        });
        thread1.start();
        System.out.println("开始thread1");
        //主线程休眠
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread1.interrupt();
        //在休眠中也能收到
        System.out.println("thread1已中断");
    }

    /**
     * 用类变量来中断,注意要加violated,来强制读取内存
     *
     * @param args
     */
    public static  boolean isQuit = false;
    public static void main(String[] args) {
        Thread thread2 = new Thread(() -> {
            while (!isQuit) {
              // System.out.println("hello thread2");
            }
        });
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        isQuit=true;

    }
}
//1:线程处于阻塞状态(sleep,wait,join),在被Interrupted唤醒
//  1) while (Thread.currentThread().isInterrupted()), 结束sleep,返回true,结束循环抛出异常,清空标志位(IsInterrupted false)
//  2) while (Thread.interrupted()), 结束sleep,返回true抛出异常,结束循环,不会清空标志位(IsInterrupted false)
//这里后续清空标志位对循环已经没有影响了,但sleep被提前唤醒,会抛出异常,清空标志位,然后在会过去执行while中条件判断,此时要退出循环就要加一个break
//2:线程处于阻塞状态(sleep,wait,join),在被带有volatile的类变量唤醒
//  1) 阻塞状态结束后出现,isQuit属性更新,所以不会抛异常,标志位不会清空
//volatile修饰的变量:不及时

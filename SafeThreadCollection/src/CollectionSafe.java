import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-02-27
 * Time: 19:40
 */
public class CollectionSafe {


    private static final int THREAD_COUNT = 3;
    private static final int OPERATIONS_PER_THREAD = 10000;

    private static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        // 创建并启动多个线程进行写操作
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread writerThread = new Thread(() -> {
                for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                    list.add(j);
                }
            });
            writerThread.start();
        }

        // 创建并启动多个线程进行读操作
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread readerThread = new Thread(() -> {
                for (int j = 0; j < OPERATIONS_PER_THREAD; j++) {
                    int size = list.size(); // 读取列表大小
                    System.out.println("List size: " + size);
                    try {
                        Thread.sleep(10); // 模拟其他处理
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            readerThread.start();
        }
    }
}



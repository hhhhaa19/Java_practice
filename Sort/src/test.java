import java.util.Arrays;
import java.util.Random;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-17
 * Time: 19:03
 */
public class test {



    private static void testQuick(int[] array) {
        int[] temArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        sort.quickSort(temArray);
        long endTime = System.currentTimeMillis();
        System.out.println("快排优化"+(endTime-startTime));
    }

    private static void testBubble(int[] array) {
        int[] temArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        sort.bubbleSort(temArray);
        long endTime = System.currentTimeMillis();
        System.out.println("冒泡优化"+(endTime-startTime));
    }

    private static void testHeap(int[] array) {
        int[] temArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        sort.heapSort(temArray);
        long endTime = System.currentTimeMillis();
        System.out.println("堆排"+(endTime-startTime));

    }

    private static void testSelect(int[] array) {
        int[] temArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        sort.selectSort(temArray);
        long endTime = System.currentTimeMillis();
        System.out.println("选排优化"+(endTime-startTime));

    }

    private static void testShell(int[] array) {
        int[] temArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        sort.shellSort(temArray);
        long endTime = System.currentTimeMillis();
        System.out.println("希尔优化"+(endTime-startTime));
    }

    private static void testInsert(int[] array) {
        int[] temArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        sort.insertSort(temArray);
        long endTime = System.currentTimeMillis();
        System.out.println("插排优化"+(endTime-startTime));

    }


    private static void randOrder(int[] array) {
        Random random= new Random();
        for (int i = 0; i < array.length; i++) {
            array[i]=random.nextInt(10000);
        }
    }

    private static void initOrder(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]=i;
        }
    }
    private static void testQuickNor(int[] array) {
        int[] temArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        sort.quickSortNor(temArray);
        long endTime = System.currentTimeMillis();
        System.out.println("快排非递归"+(endTime-startTime));
    }

    private static void testMergeNor(int[] array) {
        int[] temArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        sort.mergeSortNor(temArray);
        long endTime = System.currentTimeMillis();
        System.out.println("归并排非递归"+(endTime-startTime));
    }

    private static void testMerge(int[] array) {
        int[] temArray = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        sort.mergeSort(temArray);
        long endTime = System.currentTimeMillis();
        System.out.println("归并排"+(endTime-startTime));
    }
    public static void main1(String[] args) {
        int []arr ={3,4,63,2,53,39,23,56,2};
        sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] array = new int[10000];
        //initOrder(array);
        randOrder(array);
        testInsert(array);
        testShell(array);
        testSelect(array);
        testHeap(array);
        testBubble(array);
        testQuick(array);
        testMerge(array);
        testMergeNor(array);
        testQuickNor(array);
    }

}

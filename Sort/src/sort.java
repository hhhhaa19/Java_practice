/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-17
 * Time: 18:47
 */
public class sort {
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int cur =array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > cur) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = cur;
        }
    }

    // 希尔排序
    public static void shellSort(int[] array) {
        int num = array.length;
        int gap = num/2;
        while (gap != 1) {
            helpshellSort(array, gap);
            gap /= 2;
        }
        helpshellSort(array, gap);
    }

    private static void helpshellSort(int[] array, int gap) {
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > cur) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = cur;
        }
    }
}

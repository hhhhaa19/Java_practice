/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-17
 * Time: 18:47
 */
public class sort {
    //插排
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int cur = array[i];
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
        int gap = num / 2;
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

    // 选择排序
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minindex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minindex]) {
                    minindex = j;
                }
            }
            swap(array, i, minindex);
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    // 堆排序
    public static void heapSort(int[] array) {
        createheap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, i, 0);
            shiftDown(0, i, array);
        }
    }

    private static void createheap(int[] array) {
        int len = array.length - 1;
        int parent = (len - 1 - 1) / 2;
        while (parent >= 0) {
            shiftDown(parent, len, array);
            parent--;
        }
    }

    private static void shiftDown(int parent, int usedsize, int[] heap) {
        //左节点
        int child = parent * 2 + 1;
        while (child < usedsize) {
            //存在右节点
            if (child + 1 < usedsize) {
                child = heap[child] > heap[child + 1] ? child : child + 1;
            }
            //找到子节点中的最大值
            if (heap[child] > heap[parent]) {
                swap(heap, child, parent);
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int flag = 0;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }

    // 快速
    public static void quickSort(int[] array) {
        helpQuick(array, 0, array.length - 1);
    }

    private static void helpQuick(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int div = partion(array, left, right);
        helpQuick(array, left, div - 1);
        helpQuick(array, div + 1, right);
    }

    //挖坑
    private static int partion(int[] array, int left, int right) {
        int temp = array[left];
        while (left < right) {

            while (left < right && array[right] >= temp) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left]= temp;
        return left;
    }
}

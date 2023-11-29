import java.util.Stack;


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
            int  tempindex = j;
            for (; j >= 0; j--) {
                tempindex=j;
                if (array[tempindex] > cur) {
                    array[tempindex+1] = array[tempindex];
                } else {
                    break;
                }
            }
            array[tempindex + 1] = cur;
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

    //选排排左右同时进行
    public static void selectSort2(int[] array) {
        for (int i = 0; i < array.length - i; i++) {
            int minindex = i;
            int maxindex = array.length - i - 1;
            for (int j = i; j < array.length - i; j++) {
                if (array[j] < array[minindex]) {
                    minindex = j;
                }
                if (array[j] > array[maxindex]) {
                    maxindex = j;
                }
            }
            swap(array, i, minindex);
            if (maxindex == i) {
                maxindex = minindex;
            }
            swap(array, array.length - i - 1, maxindex);
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
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, i, 0);
            //堆排与建堆不同，最后一个数不能算进去
            shiftDown(0, i, array);
        }
    }

    private static void createheap(int[] array) {
        int len = array.length;
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
    //优化的两种方式:三数中值取k
    //小区间插排
    public static void quickSort(int[] array) {
        helpQuick(array, 0, array.length - 1);
    }

    private static void helpQuick(int[] array, int left, int right) {
        //最后小区间进行插排
        if (right - left <= 10) {
            insertQuickSort(array, left, right);
            return;
        }
        int mid = midArray(array, left, right);
        swap(array, mid, left);
        int div = partion(array, left, right);
        helpQuick(array, left, div - 1);
        helpQuick(array, div + 1, right);
    }

    private static void insertQuickSort(int[] array, int left, int right) {
        for (int i = left; i <= right; i++) {
            int minindex = i;
            for (int j = i + 1; j <= right; j++) {
                if (array[j] < array[minindex]) {
                    minindex = j;
                }
            }
            swap(array, i, minindex);
        }
    }


    //找到array[left],array[right],中位数三数的中间大小的值，返回下标
    private static int midArray(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (array[left] < array[right]) {
            if (array[mid] < array[left]) {
                return left;
            } else if (array[mid] > array[right]) {
                return right;
            } else {
                return mid;
            }
        } else {
            //array[left] > array[right]
            if (array[mid] < array[right]) {
                return right;
            } else if (array[mid] > array[left]) {
                return left;
            } else {
                return mid;
            }
        }
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
        array[left] = temp;
        return left;
    }

    //hoare版
    private static int partion2(int[] array, int left, int right) {
        int temp = array[left];
        int temIndex = left;
        while (left < right) {

            while (left < right && array[right] >= temp) {
                right--;
            }
            while (left < right && array[left] <= temp) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, temIndex, right);
        return left;
    }
    //前后指针，前指针存，后指针找
    private static int partition3(int[] array, int left, int right) {
        int prev = left ;
        int cur = left+1;
        while (cur <= right) {
            if(array[cur] < array[left] && array[++prev] != array[cur]) {
                swap(array,cur,prev);
            }
            cur++;
        }

        swap(array,prev,left);
        return prev;
    }
    //快排，非递归
    public static void quickSortNor(int[] array) {
        Stack<Integer> st = new Stack<>();
        int div = partion(array, 0, array.length - 1);
        if (div - 1 >= 2) {
            st.push(0);
            st.push(div - 1);
        }
        if (array.length - (div + 1) >= 2) {
            st.push(div + 1);
            st.push(array.length - 1);
        }
        while (!st.isEmpty()) {
            int right = st.pop();
            int left = st.pop();
            div = partion(array, left, right);
            if (div - 1 - left >= 2) {
                st.push(0);
                st.push(div - 1);
            }
            if (right - (div + 1) >= 2) {
                st.push(div + 1);
                st.push(right);
            }
        }
    }

    public static void mergeSort(int[] array) {
        helpMergeSort(array,0, array.length-1);
    }

    private static void helpMergeSort(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        int mid = (left+right)/2;
        helpMergeSort(array,left,mid);
        helpMergeSort(array,mid+1,right);
        merge(array,left,mid,right);
    }
    private static void merge(int[] array,int left,int mid, int right ){
        int s1 = left;//可以不定义，这样写为了好理解
        int e1 = mid;//可以不定义，这样写为了好理解
        int s2 = mid+1;
        int e2 = right;//可以不定义，这样写为了好理解
        //定义一个新的数组
        int[] tmpArr = new int[right-left+1];
        int k = 0;//tmpArr数组的下标
        //同时满足 证明两个归并段 都有数据
        while (s1 <= e1 && s2 <= e2) {
            if(array[s1] <= array[s2]) {
                tmpArr[k++] = array[s1++];
            }else {
                tmpArr[k++] = array[s2++];
            }
        }
        while (s1 <= e1) {
            tmpArr[k++] = array[s1++];
        }
        while (s2 <= e2) {
            tmpArr[k++] = array[s2++];
        }
        //把排好序的数据 拷贝回原来的数组array当中
        for (int i = 0; i < tmpArr.length; i++) {
            array[i+left] = tmpArr[i];
        }
    }
    public static void mergeSortNor(int[] array) {
        int gap = 1;//每组几个数据
        while(gap< array.length){
            for (int i = 0; i < array.length; i+=gap*2) {
                int left = i;
                int right = i+(gap*2)-1;
                int mid =mid=(left+right)/2;
                if(right>= array.length-1){
                    right = array.length-1;
                }
                if(mid>= array.length-1){
                    mid = array.length-1;
                }
                merge(array,left,mid,right);
            }
            gap *= 2;
        }
    }
    //计数排序
    public static void countSort(int[] array) {
        //求数组的最大值 和 最小值  O(N)
        int minVal = array[0];
        int maxVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < minVal) {
                minVal = array[i];
            }
            if(array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        //确定计数数组的 长度
        int len = maxVal - minVal + 1;
        int[] count = new int[len];
        //遍历array数组 把数据出现的次数存储到计数数组当中   O(N)
        for (int i = 0; i < array.length; i++) {
            count[array[i]-minVal]++;
        }
        //计数数组已经存放了每个数据出现的次数
        //遍历计数数组 把实际的数据写回array数组  O(范围)
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                //这里需要重写写回array 意味着得从array的0位置开始写
                array[index] = i+minVal;
                index++;
                count[i]--;
            }
        }
    }
}

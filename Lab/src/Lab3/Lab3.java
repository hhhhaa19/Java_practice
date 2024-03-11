package Lab3;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-043
 * Time: 15:17
 */
public class Lab3 {
    public static void move() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] arrList = line.split(" ");
        int a = Integer.valueOf(arrList[0]);
        for (int i = a + 1; i <= arrList.length - 1; i++) {
            System.out.print(arrList[i] + " ");
        }
        for (int i = 1; i <= a; i++) {
            System.out.print(arrList[i] + " ");
        }
    }

    public static boolean isPalindrome(String arr) {
        int i = 0;
        int j = arr.length() - 1;
        while (i <= j) {
            if (arr.charAt(i) != arr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void triangular() {
        int[][] arr = new int[10][];
        for (int i = 0; i < 10; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                arr[i][j] = i + j;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void transform() {
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        String[] tag = time.split(":");
        if (time.indexOf("AM") == -1) {
            //为PM
            tag[0] = String.valueOf(Integer.valueOf(tag[0]) + 12);
        }
        for (int i = 0; i < tag.length - 1; i++) {
            System.out.print(tag[i] + ":");
        }
        System.out.println(tag[tag.length - 1]);
    }

    public static void main1(String[] args) {
        // move();
        Scanner scanner = new Scanner(System.in);
        System.out.println(isPalindrome(scanner.nextLine()));
    }

    public static void MergeSort(int[] arr) {
        //递归,核心我们只有一个数组，实际操作时把下标分割

        helpMergeSort(arr, 0, arr.length-1);
    }

    private static void helpMergeSort(int[] arr, int begin, int end) {
        
        if (begin == end) {
            return;
        }
        int mid = begin + (end - begin) / 2;
        helpMergeSort(arr, begin, mid);
        helpMergeSort(arr, mid + 1, end);
        merge(arr, begin, mid, end);
    }

    private static void merge(int[] arr, int begin, int mid, int end) {
        int b1 = begin;
        int e1 = mid;
        int b2 = mid + 1;
        int e2 = end;
        int[] temp = new int[end - begin + 1];
        int index = 0;
        while (b1 <= e1 && b2 < e2) {
            if (arr[b1] < arr[b2]) {
                temp[index++] = arr[b1++];
            } else {
                temp[index++] = arr[b2++];
            }
        }
        while (b1 <= e1) {
            temp[index++] = arr[b1++];
        }
        while (b2 <= e2) {
            temp[index++] = arr[b2++];
        }
        for (int cur :
                temp) {
            arr[begin++] = cur;
        }
    }

    private static int SearchMin(int[] arr) {
        //找到数组中除0的最小值，若均为0，则返回0
        int min = Integer.MAX_VALUE;
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min && arr[i] != 0) {
                min = arr[i];
            }
            if (arr[i] != 0) {
                flag = 1;
            }
        }
        if (flag == 0) {
            return 0;
        } else {
            return min;
        }
    }

    public static void cutSticks(int[] arr) {
        int flag = SearchMin(arr);
        while (flag != 0) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    arr[i] -= flag;
                    if (arr[i] != 0) {
                        System.out.print(arr[i]);
                    }
                }
            }
            flag = SearchMin(arr);
            System.out.println();
        }
    }

    public static void leap(int[] arr, int step) throws IOException {
        //找连续非0的个数，第一位不算
        //check!!!!!
        int i = 1;
        int Maxcount = 0;
        while (i < arr.length) {
            int count = 0;
            int j = i;
            while (j < arr.length && arr[j] != 0) {
                count++;
                j++;
            }
            if (count > Maxcount) {
                Maxcount = count;
            }
            i = j + 1;
        }
        if (Maxcount - step >= 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    public static void main(String[] args) {
        //triangular();
        //transform();
        int[] arr = {2, 4, 1, 7};
        MergeSort(arr);
       System.out.println(Arrays.toString(arr));
//        int[] arr = {2, 3, 5, 5, 2};
//        cutSticks(arr);
//        try {
//            leap(new int[]{0, 1, 0}, 1);//编译角度会不会检查，与实际逻辑无关
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}


import java.util.Arrays;
import java.util.Scanner;

public class logical_control {
/*    public static void main(String[] args) {
        int a = 10;
        String b = String.valueOf(a);
        String c = a + "20";
        System.out.println(c);
        int f = Integer.valueOf(c);
        System.out.println(f);
        System.out.println(b);
    }*/

    public static void main2(String[] args) {
        //编写程序数一下 1到 100 的所有整数中出现多少个数字9
     /*   int i = 1;
        int count = 0;
        while (i <= 100) {
            if (i % 10 == 9 || i / 10 == 9)
                count++;
            i++;
        }*/
        //上述方式有问题：99少算了一个9因此如下
        int i = 1;
        int count = 0;
        while (i <= 100) {
            if (i % 10 == 9)
                count++;
            if (i / 10 == 9)
                count++;
            i++;
        }
        //思考：这两种if的区别
        // System.out.println(count);
    }

    public static void main3(String[] args) {
        //判定素数
        Scanner sc = new Scanner(System.in);
        System.out.println("please input the number you want to test if it is a prime number");
        int number = sc.nextInt();
        int i = 0;
        for (i = 2; i < number; i++) {
            if (number % i == 0) {
                System.out.println("it is not a prime number");
                break;
            }
        }
        if (i == number) {
            System.out.println("it is a prime number");
        }
        sc.close();
    }

    public static void main4(String[] args) {
        //求2个整数的最大公约数
        Scanner sc = new Scanner(System.in);
        System.out.println("input two numbers and output the greatest common divisor");
        int a = sc.nextInt();
        int b = sc.nextInt();
        //辗转相减
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        System.out.println(a);
        sc.close();
    }

    public static void main5(String[] args) {
        //计算分数的值
        double number = 1.0;
        double sum = 0.0;
        for (int i = 2; i <= 100; i++) {
            number++;
            if (i % 2 == 0)
                sum -= 1 / number;
            else
                sum += 1 / number;
        }
        System.out.println(sum);
    }

    public static void main6(String[] args) {
        //打印 X 图形
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int i = 0;
            while (i < num) {
                int j = 0;
                while (j < num) {
                    if (j == i || j == num - i - 1)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                    j++;
                }
                System.out.println();
                i++;
            }
        }
    }

    public static void main7(String[] args) {
        //编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误，
        // 可以重新输 入，最多输入三次。三次均错，则提示退出程序
        int count = 3;
        String password = "Wjt164673";
        while (count > 0) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals(password)) {
                System.out.println("密码正确");
                break;
            } else {
                count--;
                System.out.println("密码错误，还剩" + count + "次");
            }
        }
    }

    public static void main8(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d*%d\t", j, i);
            }
            System.out.println();
        }
    }

    public static void main9(String[] args) {
        //. 写一个函数返回参数二进制中 1 的个数
        //提供两种写的方式
        //一、一位一位来
/*        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int count=0;
        while(num!=0){
            if((num&1)==1){
                count++;
            }
            num >>=1;
        }
        System.out.println(count);
        sc.close();*/
        //二、n&(n-1)
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        while (num != 0) {
            num &= num - 1;
            count++;
        }
        System.out.println(count);
        sc.close();
    }

    //递归求解汉诺塔问题
    public static void move(char pos1, char pos2) {
        System.out.print(pos1 + "-> " + pos2 + " ");
    }

    /**
     * @param n    盘子数
     * @param pos1 起始位
     * @param pos2 中转位
     * @param pos3 目的地
     */
    public static void hanna(int n, char pos1, char pos2, char pos3) {
        if (n == 1) {
            move(pos1, pos3);
            return;
        }
        hanna(n - 1, pos1, pos3, pos2);//先把除最大盘以外的盘子放到中间柱
        move(pos1, pos3);//把最大盘放到目标盘
        hanna(n - 1, pos2, pos1, pos3);//重复，但此时起始盘是pos2,中间盘是pos1,目标盘是pos3

    }

    public static void main10(String[] args) {
        hanna(3, 'A', 'B', 'C');
    }

    public static void transform(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }

    public static void main11(String[] args) {
        int[] arr = new int[]{1, 2, 4};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void odd_even(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] % 2 == 1) {
                left++;
            }
            while (left < right && arr[right] % 2 == 0) {
                right--;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }

    public static void main12(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5};
        odd_even(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int biarysearch(int[] arr, int tag) {
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right - left + 1) / 2;
        while (left <= right) {
            mid = left + (right - left + 1) / 2;
            if (arr[mid] == tag) {
                return mid;
            } else if (arr[mid] > tag) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main13(String[] args) {
        int[] arr = new int[]{12, 34, 56, 78, 99};
        System.out.println(biarysearch(arr, 56));
        System.out.println(biarysearch(arr, 99));
        System.out.println(biarysearch(arr, 12));
        System.out.println(biarysearch(arr, 1));
        System.out.println(biarysearch(arr, 100));
    }

    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标
    public static int[] SearchSum(int[] nums, int tag) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == tag) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                } else {
                    j++;
                }
            }
            i++;
        }
        return ret;
    }

    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    public static int RemoveRepeat(int[] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret ^= arr[i];
        }
        return ret;
    }

    public static void main14(String[] args) {
        int[] arr = {1, 2, 3, 3, 2};
        System.out.println(RemoveRepeat(arr));
    }

    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    public static int MultiNumber(int[] arr) {
        //方法一
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    public static int MultiNumber2(int[] arr) {
        //方法二:摩尔投票法
        int sum = 1;
        int cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (cur == arr[i]) {
                sum++;
            } else {
                sum--;
                if (sum == 0) {
                    cur = arr[i + 1];
                }
            }
        }
        return cur;
    }

    //给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false
    public static boolean IsConsecutiveOdd(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                count++;
                if (count >= 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
}

    public static void main15(String[] args) {
        int[] arr = {1, 4, 3, 45, 7};
        System.out.println(IsConsecutiveOdd(arr));
    }
}

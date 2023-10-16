/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-16
 * Time: 20:47
 */
public class RemoveElement {
    //以后数把前数覆盖的方式移除数据
    //这种方式不好写，主要问题出在当我们下标以及退出循环的方式，
    //测试用例：3,2,2,3
/*    public static void remove(int[] nums, int pos) {
        for (int i = pos; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == val) {
                remove(nums, i);
            } else {
                count++;
                i++;
            }
        }
        return count;
    }*/

    //采用双指针
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            if (val!=nums[right]){
                nums[left++]=nums[right++];
            }else
            {
                right--;
            }
        }
        return left+1;
    }
}
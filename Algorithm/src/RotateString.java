/**
 * Created with IntelliJ IDEA.
 * Description:给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * User: 王金涛
 * Date: 2023-10-12
 * Time: 19:57
 */
public class RotateString {
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}

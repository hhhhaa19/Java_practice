/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-16
 * Time: 21:51
 */
public class RemoveRepeatInorder {
    public int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast-1] == nums[fast]) {
                while (fast < nums.length && nums[fast-1] == nums[fast]) {
                    fast++;
                }
            } else {
                nums[slow++]=nums[fast-1];
                fast++;
            }
        }
        nums[slow]=nums[fast-1];
        return slow+1;
    }
}

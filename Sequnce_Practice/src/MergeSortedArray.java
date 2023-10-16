/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-16
 * Time: 22:13
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = nums1.length - 1;
        int indexm = m - 1;
        int indexn = n - 1;
        while (indexm >= 0 && indexn >= 0) {
            if (nums2[indexn] > nums1[indexm]) {
                nums1[cur] = nums2[indexn];
                cur--;
                indexn--;
            } else {
                nums1[cur] = nums1[indexm];
                cur--;
                indexm--;
            }
        }
        while (indexn >= 0) {
            nums1[cur] = nums2[indexn];
            cur--;
            indexn--;
        }
    }
}

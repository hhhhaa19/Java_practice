/**
 * Created with IntelliJ IDEA.
 * Description:数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。
 * User: 王金涛
 * Date: 2023-10-12
 * Time: 19:35
 */
public class DisappearNum {

    public static int disappearnum(int[] arr){
        int sum =0;
        for (int i = 0; i < arr.length+1; i++) {
            sum+=i;
        }
        for (int i = 0; i < arr.length; i++) {
            sum-=arr[i];
        }

        return sum;
    }
}

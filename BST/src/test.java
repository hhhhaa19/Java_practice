/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-11-29
 * Time: 15:43
 */
public class test {
    public static void main(String[] args) {
        BST bst = new BST();
        int[] arr ={5,3,4,1,7,8,2,6,0,9};
        for (int i = 0; i < arr.length; i++) {
            bst.insert(arr[i]);
        }
        bst.delete(5);
        System.out.println("hh");
    }
}

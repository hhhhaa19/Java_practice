/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-11
 * Time: 15:51
 */
public class Merge {
    public void merge(int A[], int m, int B[], int n) {
        int l =A.length;
    while(m!=0&&n!=0){
        if(A[m-1]>B[n-1]){
            A[l-1]=A[m-1];
            m--;
            l--;
        }else {
            A[l-1]=B[n-1];
            n--;
            l--;
        }
    }
    while(n!=0){
        A[l-1]=B[n-1];
        n--;
        l--;
    }
    }

}

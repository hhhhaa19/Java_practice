import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:经典汉诺塔问题,最难的点是在于n与a.size()的区别
 * User: Benjamin
 * Date: 2024-03-03
 * Time: 22:13
 */
class test {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        new Hanota().hanota(A,B,C);
    }
}
public class Hanota {
    public void move (List<Integer> source, List<Integer> Mid, List<Integer> dest,int n){
        if(n==0){
            return ;
        }
    if (n==1){
        dest.add(source.remove(source.size()-1));
        return;
    }
    move(source,dest,Mid,n-1);
    dest.add(source.remove(source.size()-1));
    move(Mid,source,dest,n-1);
}
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A,B,C,A.size());
    }

}

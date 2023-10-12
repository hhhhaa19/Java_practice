/**
 * Created with IntelliJ IDEA.
 * Description:一个数组中有不同的类型,但在具体使用是依旧需要强转
 * User: 王金涛
 * Date: 2023-10-12
 * Time: 16:49
 */
public class Myarray {
    Object[] arr = new Object[10];

    public void setval(int pos, Object val) {
        this.arr[pos]=val;
    }
    public Object getval(int pos){
        return this.arr[pos];
    }
}

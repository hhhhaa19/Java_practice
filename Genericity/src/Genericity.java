/**
 * Created with IntelliJ IDEA.
 * Description:泛型,他的好处是争对不同类型不需要写新的代码，可以直接使用，甚至不用重写
 * User: 王金涛
 * Date: 2023-10-12
 * Time: 16:57
 */
public class Genericity<T>{
    public Object[] arr =new Object[10];
    public void setArr(int pos,T val){
        arr[pos]=val;
    }
    public T getValue(int pos){
        return (T)arr[pos];
    }

}

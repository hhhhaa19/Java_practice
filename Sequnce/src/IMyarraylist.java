import Exception.OutofboundException;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-14
 * Time: 14:33
 */
public interface IMyarraylist<T>  {

        public void display();
        // 新增元素,默认在数组最后新增
        public void add(T data);
        // 在 pos 位置新增元素
        public void add(int pos, T data);

        // 判定是否包含某个元素
        public int indexOf(T toFind);

        // 查找某个元素对应的位置
        public boolean contains(T toFind);

        // 获取 pos 位置的元素
        public T get(int pos);


        // 给 pos 位置的元素设为【更新为】 value
        public void set(int pos, T value);

        public void remove(T key);

        // 获取顺序表长度
        public int size();

        // 清空顺序表
        public void clear();

}

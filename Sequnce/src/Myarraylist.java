import java.util.Arrays;


import Exception.OutofboundException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 王金涛
 * Date: 2023-10-14
 * Time: 14:34
 */
public class Myarraylist<T>  {

    public Object[] elem;
    public int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    public Myarraylist() {
        this.elem = new Object[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(this.elem[i] + " ");
        }
    }

    private boolean isfull(T[] elem) {
        return this.usedSize == elem.length;
    }

    private void checkcapacity(T[] elem) {
        if (this.isfull(elem)) {
            this.elem = Arrays.copyOf(elem, usedSize * 2);
        }
    }

    // 新增元素,默认在数组最后新增
    public void add(T data) {
        checkcapacity((T[])elem);
        this.elem[usedSize] = data;
        usedSize++;
    }


    private void checkPosInAdd(int pos) throws OutofboundException {
        if (pos >= 0 && pos <= usedSize) {
        } else {
            throw new OutofboundException("数组pos越界");
        }
    }

    private void checkPosInget(int pos) throws OutofboundException {
        if (pos >= 0 && pos < usedSize) {
        } else {
            throw new OutofboundException("数组pos越界");
        }
    }

    // 在 pos 位置新增元素
    public void add(int pos, T data) {
        try {
            checkPosInAdd(pos);
        } catch (OutofboundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        checkcapacity((T[])elem);
        //在pos后的数往后移
        for (int i = usedSize - 1; i >= pos; i--) {
            elem[i + 1] = elem[i];
        }
        elem[pos] = data;
        usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(T toFind) {

        return  !(indexOf(toFind) == -1);
    }

    // 查找某个元素对应的位置
    public int indexOf(T toFind) {
        for (int i = 0; i < usedSize; i++) {
            if ( toFind.equals(elem[i])) {
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public T get(int pos) {
        try {
            checkPosInget(pos);
        } catch (OutofboundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return (T)elem[pos];
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, T value) {
        try {
            checkPosInget(pos);
        } catch (OutofboundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(T key) {
        int pos = indexOf(key);
        for (int i = pos; i < usedSize - 1; i++) {
            elem[i] = elem[i + 1];
        }
        usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return usedSize;
    }

    // 清空顺序表
    public void clear() {
        usedSize = 0;
        elem = Arrays.copyOf(elem, DEFAULT_SIZE);
    }

}

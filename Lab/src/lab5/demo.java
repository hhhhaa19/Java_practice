package lab5;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-03-17
 * Time: 12:18
 */
class Box<T extends Number> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    // 返回类型为 <? extends Number> 的对象
    public static Box<? extends Number> createBox(Number value) {
        if (value instanceof Integer) {
            return new Box<>(value.intValue());
        } else if (value instanceof Double) {
            return new Box<>(value.doubleValue());
        } else {
            return null;
        }
    }
    public static <U extends Number> Box<U> createBox2(U value) {
        return new Box<>(value);
    }
}

public class demo {
    public static void main(String[] args) {
        Box<Integer>  a = (Box<Integer>) Box.createBox(1);
    }
}

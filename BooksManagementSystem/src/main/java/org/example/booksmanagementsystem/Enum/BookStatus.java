package org.example.booksmanagementsystem.Enum;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-21
 * Time: 21:52
 */
public enum BookStatus {
    DELETE(0, "已删除"),
    VALID(1, "可借阅"),
    INVALID(2, "不可借阅"),
    ;
    //可以认为枚举类就是一个普通类，也有自己的属性等等，不过因为构造方法私有(在对象属性多个时才需显式声明)，所有对象在类内枚举
    @Getter
    private int value;
    @Getter
    private String name;

    private BookStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static String getDescByValue(int value) {
        switch (value) {
            case 0:
                return DELETE.name;
            case 1:
                return VALID.getName();
            case 2:
            default:
                return INVALID.name;
        }
    }
}
